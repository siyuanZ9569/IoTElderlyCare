package com.sddec.Dto;

/**
 * Created by Trevor on 4/10/2018.
 */
public class DoorSensorDTO {
    private int residentId;

    private int sensorId;

    private long timeStamp;

    private double duration;

    public DoorSensorDTO(int residentId, int sensorId, long timeStamp, double data) {
        this.residentId = residentId;
        this.sensorId = sensorId;
        this.timeStamp = timeStamp;
        this.duration = data;
    }

    public DoorSensorDTO() {

    }

    public int getResidentId() {
        return residentId;
    }

    public int getSensorId() {
        return sensorId;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public double getDuration() {
        return duration;
    }

  /*  public void addTimeStamp(String information, String timeStamp) {
        TimeStamp timeStamper = new TimeStamp();

        timeStamper.information = information;
        timeStamper.timeStamp = timeStamp;

        this.information.add(timeStamper);
    } */
}
