package com.seniorDesign.logic.Services;

import com.seniorDesign.logic.Pojo.TIME_STAMP;
import com.seniorDesign.logic.repositories.Time_stamp_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Time_stampService {
    @Autowired
    Time_stamp_repository time_stamps;

    /**
     * List all the time_stamp that relates to the given id.
     *
     * @param id
     * @return
     */
    public List<TIME_STAMP> displayBySensorId(int id){
        return time_stamps.findBySensorId(id);
    }

    public Iterable<TIME_STAMP> displayAll(){
        return time_stamps.findAll();
    }


}
