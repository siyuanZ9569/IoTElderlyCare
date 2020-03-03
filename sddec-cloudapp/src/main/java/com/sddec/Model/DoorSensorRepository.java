package com.sddec.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * Created by Trevor on 3/31/2018.
 */
public interface DoorSensorRepository extends JpaRepository<DoorSensor,Integer> {
    ArrayList<DoorSensor> findDoorSensorByResidentId(int residentId);

    DoorSensor findDoorSensorBySensorId(int sensorId);

}
