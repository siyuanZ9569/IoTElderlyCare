package com.sddec.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.ArrayList;
import java.time.ZonedDateTime;
import java.time.ZoneId;

public interface SmartPlugEventRepository extends JpaRepository<SmartPlugEvent, Integer> {
    
    ArrayList<SmartPlugEvent> findByEventID(int eventID);

    ArrayList<SmartPlugEvent> findByDeviceID(String deviceID);

    ArrayList<SmartPlugEvent> findByDeviceAlias(String deviceAlias);

    ArrayList<SmartPlugEvent> findByStatus(String status);

    ArrayList<SmartPlugEvent> findByDatetime(ZonedDateTime datetime);

    ArrayList<SmartPlugEvent> findByDeviceAliasAndStatus(String deviceAlias, String status);

    ArrayList<SmartPlugEvent> findByDeviceAliasAndDatetime(String deviceAlias, ZonedDateTime datetime);

    ArrayList<SmartPlugEvent> findBydatetimeAfter(ZonedDateTime time);

    ArrayList<SmartPlugEvent> findByDatetimeAfterAndDatetimeBefore(ZonedDateTime lastUsed, ZonedDateTime before);

    ArrayList<SmartPlugEvent> findByDeviceAliasAndDatetimeAfterAndDatetimeBefore(String deviceAlias,
                                                                                 ZonedDateTime after, ZonedDateTime before);


}