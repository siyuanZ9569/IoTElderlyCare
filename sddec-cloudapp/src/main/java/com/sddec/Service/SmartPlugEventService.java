package com.sddec.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sddec.Dto.SmartPlugEventDTO;
import com.sddec.Model.SmartPlugEvent;
import com.sddec.Model.SmartPlugEventRepository;

import com.sddec.Model.SmartPlugDuration;
import com.sddec.Model.SmartPlugDurationRepository;

@Component
public class SmartPlugEventService {

    @Autowired
    private SmartPlugEventRepository smartPlugEventRepo;

    @Autowired
    private SmartPlugDurationRepository smartPlugDurationRepo;

    public SmartPlugEvent getEventByEventID(int eventID) {
        Optional<SmartPlugEvent> toFind = smartPlugEventRepo.findById(eventID);
        if( toFind.isPresent() ) {
            return toFind.get();
        } else {
            return null;
        }
    }

    public ArrayList<SmartPlugEvent> getEventsByAlias(String alias) {
        ArrayList<SmartPlugEvent> toFind = smartPlugEventRepo.findByDeviceAlias(alias);
        if (!toFind.isEmpty() ) {
            return toFind;
        } else {
            return null;
        }
    }

    public SmartPlugEvent addSmartPlugEvent(SmartPlugEvent eventToAdd) {


        return smartPlugEventRepo.save(eventToAdd);


    }

    public ArrayList<SmartPlugEvent> getAllSmartPlugEvents() {

        ArrayList<SmartPlugEvent> events = new ArrayList<SmartPlugEvent>(smartPlugEventRepo.findAll());


        return events;
    }

    public ArrayList<SmartPlugEvent> getSmartPlugEventsByAliaAndDateAfterAndDateBefore(String alias, ZonedDateTime dateAfter,
                                                                                       ZonedDateTime dateBefore ) {
        ArrayList<SmartPlugEvent> events = new ArrayList<>(smartPlugEventRepo.findByDeviceAliasAndDatetimeAfterAndDatetimeBefore
                (alias, dateAfter, dateBefore));
        return events;
    }


        /**
         * Retrieves Smart Plug events that are within the date range
         * TODO: IDEA: Change this to a query
         */
    public ArrayList<SmartPlugEvent> getEventsByDateRange(ZonedDateTime fromDate, ZonedDateTime toDate) {
        // todo: verify that the newArrayLIst creation works
        ArrayList<SmartPlugEvent> allEvents = new ArrayList<SmartPlugEvent>( smartPlugEventRepo.findAll() );

        ArrayList<SmartPlugEvent> filteredEvents = new ArrayList<SmartPlugEvent>( allEvents.stream().
            filter(event -> 
                (event.getDateTime().compareTo(fromDate) > 0) && (event.getDateTime().compareTo(toDate) < 0)
            )
            .collect(Collectors.toList())
        );

        return filteredEvents;
    }



    /**
     * get the lastUsedTimestamp for durations to check if there are more duarations to calculate
     * @return the timestamp of last calculated duration
     */
    public ZonedDateTime getLastDuration() {

        String time = smartPlugDurationRepo.findLastUsedTime();

        ZoneId UTC = ZoneId.of("UTC");


        ZonedDateTime time_UTC = null;

        //try parsing string as a UTC timestamp
        try {
            time_UTC = ZonedDateTime.parse(time);
        }

        //if string is formatted as yyyy-mm-dd HH:mm:ss
        catch (java.time.format.DateTimeParseException e) {
            LocalDateTime localTime = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            time_UTC = localTime.atZone(UTC);

        }






        return time_UTC;


    }

    /**
     * Get all the events that have occured since the last durations have been calculated
     * @param time The time of last duration calculation
     * @return list of events to calculate durations
     */
    public ArrayList<SmartPlugEvent> getEventsToCalc(ZonedDateTime time) {

       ArrayList<SmartPlugEvent> eventsToCalc = smartPlugEventRepo.findBydatetimeAfter(time);

       return eventsToCalc;
    }

    /**
     * Calculate the new durations and store as a list
     * @param events - new Events that durations have not been calculated it
     * @return
     */
    public ArrayList<SmartPlugDuration> getNewDurations(ArrayList<SmartPlugEvent> events) {


        ArrayList<SmartPlugDuration> newDurations = new ArrayList<SmartPlugDuration>();


        for (int i = 0; i < events.size(); i++) {
                if (events.get(i).getStatus().equals("in-use")) {

                    SmartPlugEvent start = events.get(i);


                    SmartPlugEvent end = findEventEnd(events.get(i), events, i+1);

                    if (end == null) { // a matching not-in-use was found
                        continue;
                    }

                    else {
                        Duration timeDiff = Duration.between(start.getDateTime(), end.getDateTime());


                        //save start and endtimes for the duration in UTC and convert to central time in EventService.getSmartPlugDurations()
                        ZoneId UTC =  ZoneId.of("UTC");

                        //convert Zonedatetimes back to UTC for storage in database when durationRep.save() is called
                        ZonedDateTime startUTC = start.getDateTime().withZoneSameInstant(UTC);
                        ZonedDateTime endUTC = end.getDateTime().withZoneSameInstant(UTC);



                        SmartPlugDuration newDuration = new SmartPlugDuration(start.getDeviceAlias(), start.getDeviceID(), startUTC, endUTC,  timeDiff);

                        newDurations.add(newDuration);
                    }




                }else {
                    continue;
                }
        }



        return newDurations;
    }

    /**
     * Find the end date for a given in-use event, if it can be found
     * @param toMatch
     * @param events
     * @param startIndex
     * @return
     */
    public SmartPlugEvent findEventEnd(SmartPlugEvent toMatch, ArrayList<SmartPlugEvent> events, int startIndex) {
        for (int i = startIndex; i < events.size(); i++) {
            if (events.get(i).getDeviceAlias().equals(toMatch.getDeviceAlias())) {
                if (events.get(i).getStatus().equals("not-in-use")) {
                    return events.get(i);
                }
                else {
                    //TODO
                    // What if a in-use event occurs before next not-in-use?
                }
            }
        }

        // event couldn't be found or is not in the system yet
        return null;
    }

    /**
     * get durations: if new events have occurred since last call, call getNewDurations then return all durations
     * @return list of all smart plug durations
     */
    public ArrayList<SmartPlugDuration> getSmartPlugDurations() {

        ZoneId UTC = ZoneId.of("UTC");

        ZonedDateTime lastTime = getLastDuration();

        ArrayList<SmartPlugEvent> eventsToCalc = getEventsToCalc(lastTime);



        ArrayList<SmartPlugDuration> newDurations = getNewDurations(eventsToCalc);

        ArrayList<SmartPlugDuration> allDurations;


        if (!newDurations.isEmpty()) {

            SmartPlugDuration lastUpdatedDuration = newDurations.get(newDurations.size() - 1);



          for (int i = 0; i < newDurations.size(); i++) {
              smartPlugDurationRepo.save(newDurations.get(i));
          }


          smartPlugDurationRepo.updateLastUsedTimestamp(lastUpdatedDuration.getStartTime().toString());



        }















          allDurations = new ArrayList<SmartPlugDuration>( smartPlugDurationRepo.findAll() );

          //if any duration timestamp is in UTC convert to Central before sending back to client
          //allDurations = convertTimes(allDurations);










        return allDurations;
    }


    /**
     * Check all durations and make sure the times are correctly converted from UTC to central
     * This is a bug fix that should be taken care of in ZonedDateTimeToStringConverter, but it doesn't take care of it
     * @param durations
     * @return
     */
    private ArrayList<SmartPlugDuration> convertTimes(ArrayList<SmartPlugDuration> durations) {

            ArrayList<SmartPlugDuration> copy = new ArrayList<SmartPlugDuration>(durations);

        ZoneId UTC = ZoneId.of("UTC");
        ZoneId Central = ZoneId.of("America/Chicago");


        for (SmartPlugDuration d: copy) {
            //check startime and see if it is in UTC
            if (d.getStartTime().getZone().getId().toString().equals(UTC.getId())) {

                LocalDateTime startLocal = d.getStartTime().toLocalDateTime();

                ZonedDateTime startUTC = startLocal.atZone(UTC);

                ZonedDateTime startCentral = startUTC.withZoneSameInstant(Central);
                d.setStartTime(startCentral);
            }

            //check endTime and see if it is in UTC
            if (d.getEndTime().getZone().getId().toString().equals(UTC.getId())) {
                LocalDateTime endLocal = d.getEndTime().toLocalDateTime();

                ZonedDateTime endUTC = endLocal.atZone(UTC);

                ZonedDateTime endCentral = endUTC.withZoneSameInstant(Central);
                d.setEndTime(endCentral);
            }
        }


        return copy;

    }
}


