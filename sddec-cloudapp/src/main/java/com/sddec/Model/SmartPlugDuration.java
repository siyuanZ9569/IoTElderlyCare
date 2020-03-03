package com.sddec.Model;

import com.sddec.Dto.SmartPlugDurationDTO;
import com.sddec.Model.DurationToStringConverter;
import com.sddec.Model.ZonedDateTimeToStringConverter;


import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;




@Entity
@Table(name="smart_plug_durations")
public class SmartPlugDuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int durationID;

    private String deviceID;

    private String deviceAlias;

    //use a custom converter because zoneddatetime was not saving correctly in db
    @Column
    @Convert(converter = ZonedDateTimeToStringConverter.class)
    private ZonedDateTime startTime;

    //use a custom converter because zoneddatetime was not saving correctly in db
    @Column
    @Convert(converter = ZonedDateTimeToStringConverter.class)
    private ZonedDateTime endTime;

    //duration will be stored in Duration toString() format
    @Column
    @Convert(converter = DurationToStringConverter.class)
    private Duration duration;


    protected SmartPlugDuration() {}

    public SmartPlugDuration(String deviceAlias, String deviceID, ZonedDateTime startTime, ZonedDateTime endTime, Duration duration) {
        this.deviceAlias = deviceAlias;
        this.deviceID = deviceID;



        this.startTime = startTime;
        this.endTime = endTime;



        this.duration = duration;


    }

    // Add DTO SmartPlugEvent
    public SmartPlugDuration(SmartPlugDurationDTO newSmartPlugDuration) {
        this.deviceAlias = newSmartPlugDuration.getDeviceAlias();
        this.deviceID = newSmartPlugDuration.getDeviceID();
        this.startTime = newSmartPlugDuration.getStartTime();
        this.endTime = newSmartPlugDuration.getEndTime();
        this.duration = newSmartPlugDuration.getDuration();
    }


    public int getDurationID() {
        return durationID;
    }


    public String getDeviceAlias() {
        return deviceAlias;
    }


    public String getDeviceID() {
        return deviceID;
    }


    public ZonedDateTime getStartTime() { return startTime; }

    public ZonedDateTime getEndTime() { return endTime; }

    public Duration getDuration() {
        return duration;
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
     * @param duration the  to set
     */
    public void setDuration(Duration duration) {

        this.duration = duration;


    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }



    


    

    

    
}
