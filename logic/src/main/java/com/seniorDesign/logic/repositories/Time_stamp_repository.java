package com.seniorDesign.logic.repositories;

import com.seniorDesign.logic.Pojo.TIME_STAMP;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface Time_stamp_repository extends CrudRepository<TIME_STAMP, Integer> {
    List<TIME_STAMP> findBySensorId(int sensor_id);

}

