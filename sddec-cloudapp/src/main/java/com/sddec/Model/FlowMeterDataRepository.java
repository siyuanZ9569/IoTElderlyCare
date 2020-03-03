package com.sddec.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/16/2018.
 */
public interface FlowMeterDataRepository extends JpaRepository<FlowMeterData,Integer> {
    ArrayList<FlowMeterData> findFlowMeterDataByResidentIdAndSensorId(int resId, int sensorId);
    ArrayList<FlowMeterData> findFlowMeterDataByResidentId(int resId);
}
