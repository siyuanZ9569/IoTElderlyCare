package com.sddec.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.sddec.Util.IdGenerator;

import javax.persistence.Entity;
import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by Trevor on 3/31/2018.
 */
@Entity
public class DoorSensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sensorId;

    private int residentId;

    public DoorSensor(int residentId, int sensorId) {
        this.residentId = residentId;
        this.sensorId = sensorId;
    }

    public DoorSensor(int residentId) {
        this.residentId = residentId;
    }

    public DoorSensor() {

    }


    public int getSensorId() {
        return sensorId;
    }

    public int getResidentId() {
        return residentId;
    }

    public void setSensorId(int id) {
        sensorId = id;
    }

    public void setResidentId(int id) {
        residentId = id;
    }

    @Override
    public String toString() {
        return String.format("Door Sensor: Not implemented");
    }
}
