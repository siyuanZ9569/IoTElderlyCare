package com.sddec.Dto;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;

public class SmartwatchEventDTO {

    private int eventID;

    public SmartwatchEventDTO(int eventID) {
        this.eventID = eventID;
    }

    public SmartwatchEventDTO() { }

    public int getEventID() {
        return eventID;
    }

}