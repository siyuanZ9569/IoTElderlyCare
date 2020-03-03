package com.sddec.Controller;

import com.sddec.Model.SensorContents;
import com.sddec.Service.SensorContentsService;
import com.sddec.error.ResidentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by Trevor on 11/10/2018.
 */
@RestController
public class SensorContentsController {

    @Autowired
    SensorContentsService sensorContentsService;


    @RequestMapping(method = RequestMethod.GET, value = "/sensor_contents/{res_id}",
            produces = "application/json")
    public ResponseEntity getContents(@PathVariable("res_id") int res_id) {
        ArrayList<SensorContents> contents =
                sensorContentsService.findContentsByResidentId(res_id);

        if(contents == null) {
            throw new ResidentNotFoundException("No resident by that id is found", "/sensor_contents/");
        } else {
            return ResponseEntity.ok(contents);
        }
    }
}
