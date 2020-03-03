package com.sddec.Model;

public class logicSensorEvent {
    private String sensorContent;
    private String date;

    public logicSensorEvent(String sensorContent, String date) {
        this.sensorContent = sensorContent;
        this.date = date;
    }

    public String getSensorContent() {
        return sensorContent;
    }

    public void setSensorContent(String sensorContent) {
        this.sensorContent = sensorContent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
