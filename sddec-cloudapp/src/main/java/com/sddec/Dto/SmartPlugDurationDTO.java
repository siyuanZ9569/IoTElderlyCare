package com.sddec.Dto;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class SmartPlugDurationDTO {

    private int durationID;

    private String deviceID;

    private String deviceAlias;

    private ZonedDateTime startTime;

    private ZonedDateTime endTime;

    private Duration duration;


    public SmartPlugDurationDTO(int durationID, String deviceID, String deviceAlias, ZonedDateTime startTime, ZonedDateTime endTime, Duration duration) {
        this.durationID = durationID;
        this.deviceID = deviceID;
        this.deviceAlias = deviceAlias;





        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;

    }

    public SmartPlugDurationDTO() { }

    public int getDurationID() {
        return durationID;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public String getDeviceAlias() {
        return deviceAlias;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public Duration getDuration() {
        return duration;
    }





}