package com.sddec.Controller;

import com.sddec.Dto.SensorEvent;
import com.sddec.Dto.SensorReturn;
import com.sddec.Model.SmartPlugEvent;
import com.sddec.Model.TimeStamp;
import com.sddec.Model.logicSensorEvent;
import com.sddec.Service.LogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Siyuan on 4/2/2019.
 */

@RestController
public class LogicController {

    @Autowired
    private LogicService logicService;

    @RequestMapping(method= RequestMethod.GET, value="/logic/breakfast", produces="application/json")
    public ResponseEntity getBreakfastStatus(@RequestParam("res_id") int res_id,
                                   @RequestParam("daysAgo") int daysAgo) {

//        ArrayList<TimeStamp> sensorTimestamps =
//                logicService.getSensorEvents(res_id, daysAgo);
//
//        ArrayList<SensorEvent> sensorEvents = new ArrayList<>();
//        for(int i=0; i<sensorTimestamps.size(); i++){
//            if(sensorTimestamps.get(i).getInformation() >100){
//                double duration = sensorTimestamps.get(i).getInformation();
//                Instant instant = Instant.ofEpochSecond(sensorTimestamps.get(i).getTimeStamp());
//                ZonedDateTime dateTime = ZonedDateTime.ofInstant(instant, ZoneOffset.UTC);
//                String sensorName = null;
//
//                if(sensorTimestamps.get(i).getSensorId() == 10 || sensorTimestamps.get(i).getSensorId() == 11){
//                    sensorName = "Spicy, Jar and tuber ware";
//                }
//                else if(sensorTimestamps.get(i).getSensorId() == 12 || sensorTimestamps.get(i).getSensorId() == 13){
//                    sensorName = "ceramic bowls, Fancy glasses, Cooking spray";
//                }
//                else if(sensorTimestamps.get(i).getSensorId() == 14 || sensorTimestamps.get(i).getSensorId() == 15){
//                    sensorName = "Glasses, Mugs, Cups, Bowls, Plates";
//                }
//                else if(sensorTimestamps.get(i).getSensorId() == 16){
//                    sensorName = "Pans";
//                }
//                else if(sensorTimestamps.get(i).getSensorId() == 17 || sensorTimestamps.get(i).getSensorId() == 18){
//                    sensorName = "Refrigerator";
//                }
//                else if(sensorTimestamps.get(i).getSensorId() == 19){
//                    sensorName = "Freezer door";
//                }
//                else if(sensorTimestamps.get(i).getSensorId() == 20){
//                    sensorName = "Pantry";
//                }
//                else if(sensorTimestamps.get(i).getSensorId() == 21){
//                    sensorName = "Silverware";
//                }
//                sensorEvents.add(new SensorEvent(sensorName, dateTime, res_id, duration));
//            }
//
//        }
//        ArrayList<SmartPlugEvent> smartPlugEvents = logicService.getPlugEvent(daysAgo);

        String eat = logicService.checkBreakfast(res_id, daysAgo);


        return ResponseEntity.ok(eat);
    }

    @RequestMapping(method= RequestMethod.GET, value="/logic/lunch", produces="application/json")
    public ResponseEntity getLunchStatus(@RequestParam("res_id") int res_id,
                                   @RequestParam("daysAgo") int daysAgo) {
        String eat = logicService.checkLunch(res_id, daysAgo);
        return ResponseEntity.ok(eat);
    }

    @RequestMapping(method= RequestMethod.GET, value="/logic/dinner", produces="application/json")
    public ResponseEntity getDinnerStatus(@RequestParam("res_id") int res_id,
                                         @RequestParam("daysAgo") int daysAgo) {
            String eat = logicService.checkDinner(res_id, daysAgo);
        return ResponseEntity.ok(eat);
    }

    @RequestMapping(method= RequestMethod.GET, value="/logic/sensorEvents", produces="application/json")
    public ResponseEntity getSensorEvents(@RequestParam("res_id") int res_id,
                                          @RequestParam("daysAgo") int daysAgo) {
        ArrayList<logicSensorEvent> sensorEvents = logicService.getSensorEvents(res_id, daysAgo);
        return ResponseEntity.ok(sensorEvents);
    }

    @RequestMapping(method= RequestMethod.GET, value="/logic/getLastEvent", produces="application/json")
    public ResponseEntity getLastEvent(@RequestParam("res_id") int res_id,
                                          @RequestParam("daysAgo") int daysAgo) {
        logicSensorEvent sensorEvent = logicService.getLastEvent(res_id, daysAgo);
        return ResponseEntity.ok(sensorEvent);
    }
}
