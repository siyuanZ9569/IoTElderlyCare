package com.sddec.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/15/2018.
 */
public interface TimeStampRepository extends JpaRepository<TimeStamp,Integer> {
    ArrayList<TimeStamp> findTimeStampByResidentId(int residentId);
    ArrayList<TimeStamp> findTimeStampBySensorId(int sensorId);
    ArrayList<TimeStamp> findTimeStampByResidentIdAndSensorId(int residentId, int sensorId);
    ArrayList<TimeStamp> findTimeStampByResidentIdAndTimeStampAfterAndTimeStampBefore(int residentId, long after, long before);
}
