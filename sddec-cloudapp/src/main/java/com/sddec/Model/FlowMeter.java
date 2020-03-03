package com.sddec.Model;

import com.sddec.Util.IdGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Entity;
import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by Trevor on 3/31/2018.
 */
@Entity
public class FlowMeter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sensorId;

    private int residentId;

    public FlowMeter(int resId, int flowId) {
        residentId = resId;
        sensorId = flowId;
    }
    public FlowMeter(int resId) {
        residentId = resId;
    }
    public FlowMeter() {

    }

    public int getResidentId() {
        return residentId;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setResidentId(int id) {
        residentId = id;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }


    @Override
    public String toString() {
        return String.format("Flow Meter: %s", sensorId);
    }
}
