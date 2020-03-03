package com.sddec.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.regex.Pattern;

import static org.aspectj.runtime.internal.Conversions.intValue;

/**
 * Created by Trevor on 4/10/2018.
 */
@Entity
public class TimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int timeStampId;

    private long timeStamp;

    private double information;

    private int residentId;

    private int sensorId;


    public TimeStamp(long timeStamp, double information, int residentId, int sensorId) {
        this.timeStamp = timeStamp;
        this.information = information;
        this.residentId = residentId;
        this.sensorId = sensorId;
    }

    public TimeStamp() {

    }

    public int getResidentId() {
        return residentId;
    }

    public int getTimeStampId() {
        return timeStampId;
    }

    public int getSensorId() {
        return sensorId;
    }

    public long getTimeStamp() {
        return timeStamp;
    }


    public double getInformation() {
        return information;
    }

    public void setTimeStampId(int timeStampId) {
        this.timeStampId = timeStampId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setInformation(double information) {
        this.information = information;
    }

    public void setResidentId(int residentId) {
        this.residentId = residentId;
    }



    private int getHours(){
        return intValue(this.timeStamp % 86400 /3600);
    }
    private int getMins(){
        return intValue(((this.timeStamp % 86400)%3600)/ 60);
    }
    private int getSec(){
        return intValue(this.timeStamp %86400 %3600 %60);
    }

}
