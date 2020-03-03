package com.sddec.Model;

import com.sddec.Dto.FlowMeterDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Trevor on 4/16/2018.
 */
@Entity
public class FlowMeterData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int sensorId;

    private int residentId;

    private String timeStamp;

    private String duration;

    private String flow;

    public FlowMeterData(int residentId,int sensorId, String timeStamp, String duration, String flow) {
        this.residentId = residentId;
        this.sensorId = sensorId;
        this.timeStamp = timeStamp;
        this.duration = duration;
        this.flow = flow;
    }

    public FlowMeterData() {

    }

    public FlowMeterData(FlowMeterDTO flowMeterDTO) {
        this.residentId = flowMeterDTO.getResidentId();
        this.sensorId = flowMeterDTO.getSensorId();
        this.timeStamp = flowMeterDTO.getTimeStamp();
        this.duration = flowMeterDTO.getDuration();
    }

    public int getId() {
        return id;
    }

    public int getSensorId() {
        return sensorId;
    }

    public int getResidentId() {
        return residentId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getDuration() {
        return duration;
    }

    public String getFlow() {
        return flow;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public void setResidentId(int residentId) {
        this.residentId = residentId;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }
}
