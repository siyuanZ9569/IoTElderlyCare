package com.sddec.Service;

import com.sddec.Model.SensorContents;
import com.sddec.Model.SensorContentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by Trevor on 11/10/2018.
 */
@Component
public class SensorContentsService {

    @Autowired
    private SensorContentsRepository sensorContentsRepository;

    public ArrayList<SensorContents> findContentsByResidentId(int residentId) {
        ArrayList<SensorContents> contents =
                sensorContentsRepository.findSensorContentsByResidentId(residentId);

        if(contents.isEmpty()) {
            return null;
        } else {
            return contents;
        }
    }

}
