package com.seniorDesign.logic.Controller;

import com.seniorDesign.logic.Pojo.TIME_STAMP;
import com.seniorDesign.logic.Services.Time_stampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping({"/rest/timeStamp"})
public class Time_stampController {
    @Autowired
    Time_stampService time_stampService;

    @GetMapping({"/all"})
    public Iterable<TIME_STAMP> getAll(){
        return this.time_stampService.displayAll();
    }

    @PostMapping({"/findBySensorId"})
    public List<TIME_STAMP> findBySensorId(int id){
        return this.time_stampService.displayBySensorId(id);
    }
}
