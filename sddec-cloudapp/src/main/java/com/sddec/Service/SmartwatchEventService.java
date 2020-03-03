package com.sddec.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sddec.Model.SmartwatchEventRepository;

@Component
public class SmartwatchEventService {

    @Autowired
    private SmartwatchEventRepository smartwatchEventRepo;

}


