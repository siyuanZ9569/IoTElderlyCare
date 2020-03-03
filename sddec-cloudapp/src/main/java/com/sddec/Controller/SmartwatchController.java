package com.sddec.Controller;

import com.sddec.Model.SmartPlugDuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import com.sddec.Dto.SmartPlugEventDTO;
import com.sddec.Model.SmartPlugEvent;
import com.sddec.Service.SmartwatchEventService;


/**
 * Created by Cody Brooks 2019-03-02
 */
@RestController
public class SmartwatchController {

    // Add autowired service?
    // add SmartPlugService here.
    @Autowired
    private SmartwatchEventService smartwatchEventService;

    public SmartwatchController() {

    }

    // @RequestMapping(method = RequestMethod.GET, value="/smart-plug-events/{eventID}", produces = "application/json")
    // public ResponseEntity getEventByEventId(@PathVariable("eventID") int eventID) {
    //     SmartPlugEvent event = smartwatchEventService.getEventByEventID(eventID);

    //     if (event == null) {
    //         // TODO: eventually create error
    //         throw new NullPointerException("A Smart Plug event with that ID is not present");
    //     } else {
    //         return ResponseEntity.ok(event);
    //     }
    // }
}
