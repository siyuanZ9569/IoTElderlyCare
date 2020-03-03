package com.sddec.Dto;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class SmartPlugEventDTO {

    private int eventID;

    private String deviceID;

    private String deviceAlias;

    private ZonedDateTime datetime;

    private String status;

    private Double current;

    private Double voltage;

    private Double power;

    private Double total;

    public SmartPlugEventDTO(int eventID, String deviceID, String deviceAlias, String datetime, String status, Double current, Double voltage, Double power, Double total) {
        this.eventID = eventID;
        this.deviceID = deviceID;
        this.deviceAlias = deviceAlias;

        ZoneId UTC = ZoneId.of("UTC");



        //save values in UTC time in the database
        LocalDateTime localTime = LocalDateTime.parse(datetime);
        ZonedDateTime newTime = localTime.atZone(UTC);
        this.datetime = newTime;




        this.status = status;
        this.current = current;
        this.voltage = voltage;
        this.power = power;
        this.total = total;
    }

    public SmartPlugEventDTO() { }

    public int getEventID() {
        return eventID;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public String getDeviceAlias() {
        return deviceAlias;
    }

    public ZonedDateTime getDatetime() {
        return datetime;
    }


    public String getStatus() {
        return status;
    }

 
    public Double getCurrent() {
        return current;
    }

    public Double getVoltage() {
        return voltage;
    }

    public Double getPower() {
        return power;
    }

    public Double getTotal() {
        return total;
    }


}