package com.sddec.Controller;

import com.sddec.Dto.FlowMeterDTO;
import com.sddec.Dto.MeterReturn;
import com.sddec.Model.FlowMeterData;
import com.sddec.Service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/15/2018.
 */
@RestController
public class FlowMeterController {

    @Autowired
    SensorService flowMeterService;

    @RequestMapping(method = RequestMethod.POST, value = "/flow_meter/add_entry/", produces = "application/json")
    public ResponseEntity addEntry(@RequestBody FlowMeterDTO toAdd) {
        FlowMeterData flowMeterData = new FlowMeterData(toAdd.getResidentId(), toAdd.getSensorId(), toAdd.getTimeStamp(),
                toAdd.getDuration(), toAdd.getFlow());


        flowMeterService.addRecord(flowMeterData);
        return ResponseEntity.ok(flowMeterData);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/flow_meter/get_data/{res_id}/{sensor_id}")
    public ResponseEntity getEntry(@PathVariable("res_id") int res_id, @PathVariable("sensor_id") int sensor_id) {
        ArrayList<FlowMeterData> flowMeterDatas = flowMeterService.getSensorData(res_id,sensor_id);

        MeterReturn toSend = new MeterReturn(res_id, sensor_id, flowMeterDatas);

        return ResponseEntity.ok(toSend);
    }

    @RequestMapping(method=RequestMethod.GET, value="/flow_meter/get_all/{res_id}")
    public ResponseEntity getAll(@PathVariable("res_id") int res_id) {
        ArrayList<FlowMeterData> flowMeterDatas = flowMeterService.getSensorData(res_id);

        MeterReturn toSend = new MeterReturn(res_id,  flowMeterDatas);

        return ResponseEntity.ok(toSend);
    }
}
