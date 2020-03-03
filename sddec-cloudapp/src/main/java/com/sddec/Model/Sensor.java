package com.sddec.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Trevor on 10/12/2018.
 */
@Entity
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sensorId;

    private int residentId;

    public Sensor(int sensorId, int residentId) {
        this.sensorId = sensorId;
        this.residentId = residentId;
    }

    public Sensor() {

    }

    public int getSensorId() {
        return sensorId;
    }

    public int getResidentId() {
        return residentId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public void setResidentId(int residentId) {
        this.residentId = residentId;
    }

}
