package com.sddec.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public interface SmartPlugDurationRepository extends JpaRepository<SmartPlugDuration, Integer> {
    
    ArrayList<SmartPlugDuration> findByDurationID(int durationID);

    ArrayList<SmartPlugDuration> findByDeviceID(String deviceID);

    ArrayList<SmartPlugDuration> findByDeviceAlias(String deviceAlias);



    ArrayList<SmartPlugDuration> findByStartTime(ZonedDateTime datetime);


    ArrayList<SmartPlugDuration> findByDeviceAliasAndStartTime(String deviceAlias, ZonedDateTime datetime);


    // test lastUsedTimestamp: 2019-02-07T17:56:59-06:00
    // get the last used timestamp for duration calculations from "lastTimestamp" table
    @Query(nativeQuery = true, value="select lastUsedTimestamp from lastTimestamp")
    String findLastUsedTime();


    @Modifying
    @Transactional
    @Query(nativeQuery = true, value="update lastTimestamp set lastUsedTimestamp = ?1 where ID = 1")
    void updateLastUsedTimestamp(String newTimeStamp);








}