package com.sddec.Dto;

import java.time.ZonedDateTime;

/**
    Created By Siyuan on 13/10/2019
 */
public class SensorEvent {
    private String sensorName;
    private ZonedDateTime time;
    private int userId;
    private double duration;

    public SensorEvent(String sensorName, ZonedDateTime time, int userId, double duration) {
        this.sensorName = sensorName;
        this.time = time;
        this.userId = userId;
        this.duration = duration;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
