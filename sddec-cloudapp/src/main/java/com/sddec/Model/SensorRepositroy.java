package com.sddec.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * Created by Trevor on 10/12/2018.
 */
public interface SensorRepositroy extends JpaRepository<Sensor, Integer> {
    ArrayList<Sensor> getSensorByResidentId(int residentId);

    ArrayList<Sensor> findDoorSensorByResidentId(int residentId);

    Sensor findDoorSensorBySensorId(int sensorId);

    ArrayList<Sensor> findFlowMeterByResidentId(int residentId);
}
