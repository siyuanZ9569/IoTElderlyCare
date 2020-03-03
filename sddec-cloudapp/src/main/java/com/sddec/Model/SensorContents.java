package com.sddec.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Trevor on 11/10/2018.
 */
@Entity
public class SensorContents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contentsId;

    private int sensorId;

    private String sensorName;

    private int residentId;

    public SensorContents(int contentsId, int sensorId, String sensorName, int residentId) {
        this.contentsId = contentsId;
        this.sensorId = sensorId;
        this.sensorName = sensorName;
        this.residentId = residentId;
    }

    public SensorContents() {

    }

    public int getContentsId() {
        return contentsId;
    }

    public int getSensorId() {
        return sensorId;
    }

    public String getSensorName() {
        return sensorName;
    }

    public int getResidentId() {
        return residentId;
    }

    public void setContentsId(int contentsId) {
        this.contentsId = contentsId;
    }

    public void setResidentId(int residentId) {
        this.residentId = residentId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

}
