package com.seniorDesign.logic.Pojo;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import javax.persistence.*;

@Entity
@Table(
        name = "time_stamp"
)
public class TIME_STAMP {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "time_stamp_id"
    )
    private int time_stamp_id;

    @Column(
            name = "time_stamp"
    )
    private String time_stamp;

    @Column(
            name = "information"
    )
    private String information;

    @Column(
            name = "resident_id"
    )
    private int residentId;


    @Column(
            name = "sensor_id"
    )
    private int sensorId;

    public TIME_STAMP(){

    }

    public int getTime_stamp_id() {
        return time_stamp_id;
    }

    public void setTime_stamp_id(int time_stamp_id) {
        this.time_stamp_id = time_stamp_id;
    }

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getResident_id() {
        return residentId;
    }

    public void setResident_id(int resident_id) {
        this.residentId = resident_id;
    }

    public int getSensor_id() {
        return sensorId;
    }

    public void setSensor_id(int sensor_id) {
        this.sensorId = sensor_id;
    }
}
