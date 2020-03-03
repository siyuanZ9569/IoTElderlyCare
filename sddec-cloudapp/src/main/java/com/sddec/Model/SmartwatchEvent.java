package com.sddec.Model;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;

// import com.sddec.Dto.UserDTO;
// import com.sddec.Util.IdGenerator;

import javax.persistence.*;
import com.sddec.Util.IdGenerator;


import com.sddec.Dto.SmartwatchEventDTO;

@Entity
@Table(name="smartwatch_events")
public class SmartwatchEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventID;

}