package com.sddec.Controller;

import com.sddec.Dto.DoorSensorDTO;
import com.sddec.Dto.SensorReturn;
import com.sddec.Model.Sensor;
import com.sddec.Model.TimeStamp;
import com.sddec.Service.SensorService;
import com.sddec.error.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/10/2018.
 */
@RestController
public class DoorSensorController {

    @Autowired
    private SensorService doorSensorService;

    @RequestMapping(method = RequestMethod.POST, value = "/door_sensor/add_entry/", produces = "application/json")
    public ResponseEntity addEntry(@RequestBody DoorSensorDTO toAdd) {
        TimeStamp newTimeStamp = new TimeStamp(toAdd.getTimeStamp(), toAdd.getDuration(), toAdd.getResidentId(),
                toAdd.getSensorId());
        Sensor check = doorSensorService.getSensorById(toAdd.getSensorId());

        if(check.equals(null)) {
            throw new UserNotFoundException("No user with that id", "/door_sensor/add_entry");
        } else {
            doorSensorService.addRecord(newTimeStamp);
            return ResponseEntity.ok(newTimeStamp);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/door_sensor/get_data/{res_id}/{sensor_id}",
            produces = "application/json")
    public ResponseEntity getEntry(@PathVariable("res_id") int res_id, @PathVariable("sensor_id") int sensorId) {

        ArrayList<TimeStamp> timeStamps = doorSensorService.getSensorInfoByResId(res_id, sensorId);

        SensorReturn toSend = new SensorReturn(res_id, sensorId, timeStamps);

        return ResponseEntity.ok(toSend);
    }

    @RequestMapping(method=RequestMethod.GET, value="/door_sensor/get_all/{res_id}", produces="application/json")
    public ResponseEntity getAll(@PathVariable("res_id") int res_id) {

        ArrayList<TimeStamp> timeStamps = doorSensorService.getSensorInfoByResId(res_id);
        SensorReturn toSend = new SensorReturn(res_id, timeStamps);

        return ResponseEntity.ok(toSend);
    }

    /**
     * Get all the door events between a date range.
     * @param res_id The resident to get events for.
     * @param dateAfter Only get events after this date (timestamp).
     * @param dateBefore Only get events before this date (timestamp).
     * @return A list of door senosr events.
     */
    @RequestMapping(method=RequestMethod.GET, value="/door_sensor/get_between/{res_id}/{date_after}/{date_before}", produces="application/json")
    public ResponseEntity getEntry(@PathVariable("res_id") int res_id, @PathVariable("date_after") long dateAfter,
        @PathVariable("date_before") long dateBefore) {

            ArrayList<TimeStamp> timeStamps =
                    doorSensorService.getSensorInfoByResIdAndBeforeDateAndAfterDate(res_id, dateAfter, dateBefore);
            SensorReturn toSend = new SensorReturn(res_id, timeStamps);

            return ResponseEntity.ok(toSend);
    }
}
