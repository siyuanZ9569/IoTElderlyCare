package com.sddec.Service;

import com.sddec.Model.DoorSensor;
import com.sddec.Model.DoorSensorRepository;
import com.sddec.Model.TimeStamp;
import com.sddec.Model.TimeStampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by Trevor on 4/10/2018.
 */
@Component
public class DoorSensorService {

    @Autowired
    private DoorSensorRepository doorSensorRepository;

    @Autowired
    TimeStampRepository timeStampRepository;

    public DoorSensor getSensorById(int id) {
        Optional<DoorSensor> doorSensor = doorSensorRepository.findById(id);

        if(doorSensor.isPresent()) {
            return doorSensor.get();
        } else {
            return null;
        }
    }

    public ArrayList<TimeStamp> getSensorInfoByResId(int resId, int sensorId) {
        ArrayList<TimeStamp> timeStamps = timeStampRepository.findTimeStampByResidentIdAndSensorId(resId, sensorId);


        return timeStamps;
    }

    public ArrayList<TimeStamp> getSensorInfoByResId(int resId) {
        ArrayList<TimeStamp> timeStamps = timeStampRepository.findTimeStampByResidentId(resId);


        return timeStamps;
    }

    public TimeStamp addRecord(TimeStamp newRecord) {


        timeStampRepository.save(newRecord);
        return newRecord;
    }


}
