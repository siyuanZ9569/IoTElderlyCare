package com.sddec.Dto;

import com.sddec.Model.SmartPlugEvent;
import com.sddec.Model.TimeStamp;


import java.util.ArrayList;

/**
 * Created by Trevor on 4/15/2018.
 */
public class SensorReturn {
    private int residentId;

    private String eat;

    private ArrayList<SensorEvent> sensorEvents;

    private ArrayList<SmartPlugEvent> userPlug;

    private ArrayList<TimeStamp> data;

    private int sensorId;

    public SensorReturn(int residentId, String eat, ArrayList<SensorEvent> sensorEvents, ArrayList<SmartPlugEvent> userPlug) {
        this.residentId = residentId;
        this.eat = eat;
        this.sensorEvents = sensorEvents;
        this.userPlug = userPlug;
    }

    public SensorReturn(int residentId, int sensorId, ArrayList<TimeStamp> data) {
        this.residentId = residentId;
        this.sensorId = sensorId;
        this.data = data;
    }


    public SensorReturn(int residentId,  ArrayList<TimeStamp> data) {
        this.residentId = residentId;
        this.data = data;
    }


    public ArrayList<SmartPlugEvent> getUserPlug() {
        return userPlug;
    }

    public void setUserPlug(ArrayList<SmartPlugEvent> userPlug) {
        this.userPlug = userPlug;
    }

    public int getResidentId() {
        return residentId;
    }

    public int getSensorId() {
        return sensorId;
    }

    public ArrayList<TimeStamp> getData() {
        return data;
    }

    public void setResidentId(int residentId) {
        this.residentId = residentId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public void setData(ArrayList<TimeStamp> data) {
        this.data = data;
    }

    public String getEat() {
        return eat;
    }

    public void setEat(String eat) {
        this.eat = eat;
    }

    public ArrayList<SensorEvent> getSensorEvents() {
        return sensorEvents;
    }

    public void setSensorEvents(ArrayList<SensorEvent> sensorEvents) {
        this.sensorEvents = sensorEvents;
    }
}
