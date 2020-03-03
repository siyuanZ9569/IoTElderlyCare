package com.sddec.Dto;

import com.sddec.Model.FlowMeterData;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/16/2018.
 */
public class MeterReturn {
    private int residentId;
    private int sensorId;
    private ArrayList<FlowMeterData> flowData;

    public MeterReturn(int residentId, int sensorId, ArrayList<FlowMeterData> flowData) {
        this.residentId = residentId;
        this.sensorId = sensorId;
        this.flowData = flowData;
    }

    public MeterReturn(int residentId,  ArrayList<FlowMeterData> flowData) {
        this.residentId = residentId;
        this.sensorId = 0;
        this.flowData = flowData;
    }

    public int getResidentId() {
        return residentId;
    }

    public int getSensorId() {
        return sensorId;
    }

    public ArrayList<FlowMeterData> getFlowData() {
        return flowData;
    }
}
