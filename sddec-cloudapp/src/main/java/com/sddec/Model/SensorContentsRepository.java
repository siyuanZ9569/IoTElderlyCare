package com.sddec.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * Created by Trevor on 11/10/2018.
 */
public interface SensorContentsRepository extends JpaRepository<SensorContents, Integer> {
    ArrayList<SensorContents> findSensorContentsByResidentId(int residentId);
}
