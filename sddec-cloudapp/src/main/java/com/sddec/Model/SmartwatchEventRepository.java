package com.sddec.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.ArrayList;
import java.time.ZonedDateTime;
import java.time.ZoneId;

public interface SmartwatchEventRepository extends JpaRepository<SmartPlugEvent, Integer> {
    
    // ArrayList<SmartPlugEvent> findByEventID(int eventID);

}