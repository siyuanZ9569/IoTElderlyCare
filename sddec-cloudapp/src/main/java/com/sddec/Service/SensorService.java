package com.sddec.Service;

import com.sddec.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by Trevor on 10/15/2018.
 */
@Component
public class SensorService {
    @Autowired
    private SensorRepositroy doorSensorRepository;

    @Autowired
    TimeStampRepository timeStampRepository;

    @Autowired
    SensorRepositroy flowMeterRepository;

    @Autowired
    FlowMeterDataRepository flowMeterDataRepository;


    public Sensor getFlowMeterById(int id) {
        Optional<Sensor> flowMeter = flowMeterRepository.findById(id);

        if(flowMeter.isPresent()) {
            return flowMeter.get();
        } else {
            return null;
        }
    }

    public Sensor getFlowMeterByResidentId(int id) {
        ArrayList<Sensor> flowMeters = flowMeterRepository.findFlowMeterByResidentId(id);

        if(flowMeters.isEmpty()) {
            return null;
        } else {
            return flowMeters.get(0);
        }
    }

    public ArrayList<FlowMeterData> getSensorData(int residentId, int sensorId) {
        ArrayList<FlowMeterData> timeStamps = flowMeterDataRepository.findFlowMeterDataByResidentIdAndSensorId(residentId,
                sensorId);

        return timeStamps;
    }


    public ArrayList<FlowMeterData> getSensorData(int residentId) {
        ArrayList<FlowMeterData> timeStamps = flowMeterDataRepository.findFlowMeterDataByResidentId(residentId);
        return timeStamps;
    }

    public FlowMeterData addRecord(FlowMeterData newRecord) {
        flowMeterDataRepository.save(newRecord);

        return newRecord;
    }

    public Sensor getSensorById(int id) {
        Optional<Sensor> doorSensor = doorSensorRepository.findById(id);

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

    public ArrayList<TimeStamp> getSensorInfoByResIdAndBeforeDateAndAfterDate(int resId, long after, long before) {
        ArrayList<TimeStamp> timeStamps =
            timeStampRepository.findTimeStampByResidentIdAndTimeStampAfterAndTimeStampBefore(resId, after, before);

        return timeStamps;
    }
}
