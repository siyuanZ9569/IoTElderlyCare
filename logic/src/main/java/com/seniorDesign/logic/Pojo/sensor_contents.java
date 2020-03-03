//package com.seniorDesign.logic.Pojo;
//
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//public class sensor_contents {
//    @Id
//    @GeneratedValue(
//            strategy = GenerationType.IDENTITY
//    )
//    @Column(
//            name = "content_id"
//    )
//    private int content_id;
//
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
//    @Column(
//            name = "sensor_name"
//    )
//    private String sensor_name;
//
//    public sensor_contents(){
//
//    }
//
//    public int getContent_id() {
//        return content_id;
//    }
//
//    public void setContent_id(int content_id) {
//        this.content_id = content_id;
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
//
//    public String getSensor_name() {
//        return sensor_name;
//    }
//
//    public void setSensor_name(String sensor_name) {
//        this.sensor_name = sensor_name;
//    }
//}
