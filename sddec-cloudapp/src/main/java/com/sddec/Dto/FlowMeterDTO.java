package com.sddec.Dto;

/**
 * Created by Trevor on 4/15/2018.
 */
public class FlowMeterDTO {
    private int residentId;
    private int sensorId;
    private String timeStamp;
    private String flow;
    private String duration;

    public FlowMeterDTO(int residentId, int sensorId, String timeStamp, String flow, String duration) {
        this.residentId = residentId;
        this.sensorId = sensorId;
        this.timeStamp = timeStamp;
        this.flow = flow;
        this.duration = duration;
    }

    public FlowMeterDTO() {

    }

    public int getResidentId() {
        return residentId;
    }

    public int getSensorId() {
        return sensorId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getFlow() {
        return flow;
    }

    public String getDuration() {
        return duration;
    }
}
