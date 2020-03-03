package com.sddec.Service;

import com.sddec.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by Trevor on 4/15/2018.
 */
@Component
public class FlowMeterService {

    @Autowired
    FlowMeterRepository flowMeterRepository;

    @Autowired
    FlowMeterDataRepository flowMeterDataRepository;


    public FlowMeter getFlowMeterById(int id) {
        Optional<FlowMeter> flowMeter = flowMeterRepository.findById(id);

        if(flowMeter.isPresent()) {
            return flowMeter.get();
        } else {
            return null;
        }
    }

    public FlowMeter getFlowMeterByResidentId(int id) {
        ArrayList<FlowMeter> flowMeters = flowMeterRepository.findFlowMeterByResidentId(id);

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


}
