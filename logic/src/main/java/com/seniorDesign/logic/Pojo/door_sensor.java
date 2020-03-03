//package com.seniorDesign.logic.Pojo;
//
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//public class door_sensor {
//    @Id
//    @GeneratedValue(
//            strategy = GenerationType.IDENTITY
//    )
//    @Column(
//            name = "sensor_id"
//    )
//    private int sensor_id;
//
//    @Column(
//            name = "resident_id"
//    )
//    private int resident_id;
//
//    public door_sensor(){
//
//    }
//    public door_sensor(int sensorId, int residentId){
//        this.sensor_id=sensorId;
//        this.resident_id=residentId;
//    }
//
//    public int getSensor_id() {
//        return sensor_id;
//    }
//
//    public void setSensor_id(int sensor_id) {
//        this.sensor_id = sensor_id;
//    }
//
//    public int getResident_id() {
//        return resident_id;
//    }
//
//    public void setResident_id(int resident_id) {
//        this.resident_id = resident_id;
//    }
//}
