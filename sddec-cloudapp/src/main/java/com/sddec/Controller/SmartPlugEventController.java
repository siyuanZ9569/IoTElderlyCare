package com.sddec.Controller;

import com.sddec.Model.SmartPlugDuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import com.sddec.Dto.SmartPlugEventDTO;
import com.sddec.Model.SmartPlugEvent;
import com.sddec.Service.SmartPlugEventService;



/**
 * Created by Justin Somers 11/19/18
 */
@RestController
public class SmartPlugEventController {

    // Add autowired service?
    // add SmartPlugService here.
    @Autowired
    private SmartPlugEventService smartPlugEventService;



    public SmartPlugEventController() {

    }

    @RequestMapping(method = RequestMethod.GET, value="/smart-plug-events/eventID/{eventID}", produces = "application/json")
    public ResponseEntity getEventByEventId(@PathVariable("eventID") int eventID) {
        SmartPlugEvent event = smartPlugEventService.getEventByEventID(eventID);

        if (event == null) {
            // TODO: eventually create error
            throw new NullPointerException("A Smart Plug event with that ID is not present");
        } else {
            return ResponseEntity.ok(event);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/smart-plug-events/alias/{alias}", produces = "application/json")
    public ResponseEntity getEventsByAlias(@PathVariable("alias") String alias) {
        ArrayList<SmartPlugEvent> events = smartPlugEventService.getEventsByAlias(alias);

        if ( events == null) {
            throw new NullPointerException("A smart plug event with that alias is not present");
        } else {
            return ResponseEntity.ok(events);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/smart-plug-events/alias-after-before/{alias}/{dateAfter}/{dateBefore}",
            produces = "application/json")
    public ResponseEntity getEventsByAlias(@PathVariable("alias") String alias, @PathVariable("dateAfter") int dateAfter) {
        LocalDateTime boundDateAndTime = LocalDate.now().minusDays(dateAfter-1).atStartOfDay();
        LocalDateTime targetdayDataAndTime = LocalDate.now().minusDays(dateAfter).atStartOfDay();
        ZoneId zoneId = ZoneId.of("UTC");
        ZonedDateTime bound = ZonedDateTime.of(boundDateAndTime, zoneId);
        ZonedDateTime tagetDay = ZonedDateTime.of(targetdayDataAndTime, zoneId);
        ArrayList<SmartPlugEvent> events = smartPlugEventService.getSmartPlugEventsByAliaAndDateAfterAndDateBefore(alias, tagetDay, bound);

        if ( events == null) {
            throw new NullPointerException("A smart plug event with that alias is not present");
        } else {
            return ResponseEntity.ok(events);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value="/smart-plug-events", consumes="application/json")
    public @ResponseBody SmartPlugEvent addSmartPlugEvent(@RequestBody SmartPlugEvent event) {
        // SmartPlugEvent event2 = new SmartPlugEvent(event);
         SmartPlugEvent returnedEvent = smartPlugEventService.addSmartPlugEvent(event);
         return returnedEvent;

    }

    @RequestMapping(method = RequestMethod.GET, value="/smart-plug-events", produces = "application/json")
    public ResponseEntity getAllEvents() {
        ArrayList<SmartPlugEvent> events = smartPlugEventService.getAllSmartPlugEvents();
        
        if ( events == null) {
            throw new NullPointerException("Events returned null");
        } else {
            return ResponseEntity.ok(events);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/smart-plug-lastDuration", produces = "application/json")
    public ZonedDateTime getTimestamp() {
        ZonedDateTime time = smartPlugEventService.getLastDuration();

        if (time == null) {
            throw new NullPointerException("last Timestamp null");
        }
        else {
            return time;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/smart-plug-getEventsToCalc", produces = "application/json")
    public ArrayList<SmartPlugEvent> getEventsToCalc() {
        ZonedDateTime time = getTimestamp();

        ArrayList<SmartPlugEvent> eventsToCalc = smartPlugEventService.getEventsToCalc(time);

        if (eventsToCalc == null) {
            throw new NullPointerException("no new events to calculate");
        }

        else {
            return eventsToCalc;
        }

    }

    @RequestMapping(method = RequestMethod.GET, value="/smart-plug-newDurations", produces = "application/json")
    public ArrayList<SmartPlugDuration> getNewDurations() {

        ZonedDateTime lastTime = smartPlugEventService.getLastDuration();

        ArrayList<SmartPlugEvent> eventsToCalc = smartPlugEventService.getEventsToCalc(lastTime);



       ArrayList<SmartPlugDuration> newDurations = smartPlugEventService.getNewDurations(eventsToCalc);

       return newDurations;


    }


    @RequestMapping(method = RequestMethod.GET, value="/smart-plug-durations", produces ="application/json")
    public ArrayList<SmartPlugDuration> getDurations() {
        ArrayList<SmartPlugDuration> durations = smartPlugEventService.getSmartPlugDurations();

        return durations;
    }
}
