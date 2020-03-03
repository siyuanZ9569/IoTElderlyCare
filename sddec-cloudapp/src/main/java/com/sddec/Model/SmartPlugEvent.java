package com.sddec.Model;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;

// import com.sddec.Dto.UserDTO;
// import com.sddec.Util.IdGenerator;

import javax.persistence.*;
import com.sddec.Util.IdGenerator;


import com.sddec.Dto.SmartPlugEventDTO;


@Entity
@Table(name="smart_plug_events")
public class SmartPlugEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventID;

    private String deviceID;

    private String deviceAlias;

    //use a custom converter because zoneddatetime was not saving correctly in db
    @Column
    @Convert(converter = ZonedDateTimeToStringConverter.class)
    private ZonedDateTime datetime;

    private String status;

    private Double current;

    private Double voltage;

    private Double power;
    
    private Double total;

    protected SmartPlugEvent() {}

    public SmartPlugEvent(String deviceAlias, String deviceID, String datetime, String status, Double current, Double voltage, Double power, Double total) {
        this.deviceAlias = deviceAlias;
        this.deviceID = deviceID;

        ZonedDateTime newTime = ZonedDateTime.parse(datetime);


        this.datetime = newTime;




        this.status = status;
        this.current = current;
        this.voltage = voltage;
        this.power = power;
        this. total = total;
    }

    // Add DTO SmartPlugEvent
    public SmartPlugEvent(SmartPlugEventDTO newSmartPlugEvent) {
        this.deviceAlias = newSmartPlugEvent.getDeviceAlias();
        this.deviceID = newSmartPlugEvent.getDeviceID();




        this.datetime = newSmartPlugEvent.getDatetime();
        this.status = newSmartPlugEvent.getStatus();
        this.current = newSmartPlugEvent.getCurrent();
        this.voltage = newSmartPlugEvent.getVoltage();
        this.power = newSmartPlugEvent.getPower();
        this.total = newSmartPlugEvent.getTotal();
    }


    public int getEventID() {
        return eventID;
    }


    public String getDeviceAlias() {
        return deviceAlias;
    }


    public String getDeviceID() {
        return deviceID;
    }

 
    public ZonedDateTime getDateTime() {
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

    /**
     * @param deviceAlias the alias to set
     */
    public void setDeviceAlias(String deviceAlias) {
        this.deviceAlias = deviceAlias;
    }

    /*
    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }
    */

    /**
     * @param dateTime the dateTime to set
     */
    public void setDateTime(ZonedDateTime dateTime) {
        this.datetime = dateTime;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @param current the current to set
     */
    public void setCurrent(Double current) {
        this.current = current;
    }
    
    /**
     * @param voltage the voltage to set
     */
    public void setVoltage(Double voltage) {
        this.voltage = voltage;
    }


    public void setPower(Double power) {
        this.power = power;
    }


    public void setTotal(Double total) {
        this.total = total;
    }

    

    

    
}
