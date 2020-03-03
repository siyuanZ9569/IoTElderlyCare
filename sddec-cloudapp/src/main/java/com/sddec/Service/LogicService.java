package com.sddec.Service;


import com.sddec.Model.*;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.*;
import java.util.ArrayList;

/**
 * Created by Siyuan on 4/2/2019.
 */

@Component
public class LogicService {
    @Autowired
    private DoorSensorRepository doorSensorRepository;

    @Autowired
    private SmartPlugEventRepository smartPlugEventRepository;

    @Autowired
    TimeStampRepository timeStampRepository;

    public String checkBreakfast(int residentId, int daysAgo){
        JSONObject eat = new JSONObject();
        eventsCheckHelper(eat, residentId, daysAgo, 0, 16);
        return eat.toString();
    }

    public String checkLunch(int residentId, int daysAgo){
        JSONObject eat = new JSONObject();
        eventsCheckHelper(eat, residentId, daysAgo, 16, 19);
        return eat.toString();
    }

    public String checkDinner(int residentId, int daysAgo){
        JSONObject eat = new JSONObject();
        eventsCheckHelper(eat, residentId, daysAgo, 19, 24);
        return eat.toString();
    }

    public ArrayList<SmartPlugEvent> getPlugEvent(int daysAgo){
        LocalDateTime boundDateAndTime = LocalDate.now().minusDays(daysAgo-1).atStartOfDay();
        LocalDateTime targetdayDataAndTime = LocalDate.now().minusDays(daysAgo).atStartOfDay();
        ZoneId zoneId = ZoneId.of("GMT");
        ZonedDateTime bound = ZonedDateTime.of(boundDateAndTime, zoneId);
        ZonedDateTime tagetDay = ZonedDateTime.of(targetdayDataAndTime, zoneId);

        ArrayList<SmartPlugEvent> getAllEvents= smartPlugEventRepository.findByDatetimeAfterAndDatetimeBefore
                ( tagetDay, bound);
        ArrayList<SmartPlugEvent> toSend = new ArrayList<>();

        for(int i=0; i<getAllEvents.size(); i++){
            if(getAllEvents.get(i).getStatus().equals("in-use") || getAllEvents.get(i).getStatus().equals("power-on")){
                toSend.add(getAllEvents.get(i));
            }
        }
        return toSend;
    }

    public ArrayList<logicSensorEvent> getSensorEvents(int residentId, int daysAgo) {
        ArrayList<logicSensorEvent> sensorEvents = new ArrayList<>();
        long ut1 = Instant.now().getEpochSecond();
        ut1 -= ut1 % 86400;
        long daysAgo_time = (ut1) - daysAgo * 86400;
        long after_time = daysAgo_time;
        long before_time = daysAgo_time + 86399;
        ArrayList<TimeStamp> TimeStamps =
                timeStampRepository.findTimeStampByResidentIdAndTimeStampAfterAndTimeStampBefore(residentId, after_time, before_time);
        for(int i=0; i< TimeStamps.size(); i++){
            String readableTime = timeStamp2Date(TimeStamps.get(i).getTimeStamp()).toString();
            String sensorContent = getSensorContent(TimeStamps.get(i).getSensorId());
            logicSensorEvent sensorEvent = new logicSensorEvent(sensorContent, readableTime);
            sensorEvents.add(sensorEvent);
        }
        return sensorEvents;
    }

    public logicSensorEvent getLastEvent(int residentId, int daysAgo) {
        long ut1 = Instant.now().getEpochSecond();
        ut1 -= ut1 % 86400;
        long daysAgo_time = (ut1) - daysAgo * 86400;
        long after_time = daysAgo_time;
        long before_time = daysAgo_time + 86399;
        ArrayList<TimeStamp> TimeStamps =
                timeStampRepository.findTimeStampByResidentIdAndTimeStampAfterAndTimeStampBefore(residentId, after_time, before_time);
        int size = TimeStamps.size();
        if(size ==0){
            return new logicSensorEvent("No events", "No time");
        }
        String readableTime = timeStamp2Date(TimeStamps.get(size-1).getTimeStamp()).toString();
        String sensorContent = getSensorContent(TimeStamps.get(size-1).getSensorId());
        logicSensorEvent sensorEvent = new logicSensorEvent(sensorContent, readableTime);

        return sensorEvent;
    }

    private void eventsCheckHelper(JSONObject eat, int residentId, int daysAgo, int startHour, int endHour){
        long ut1 = Instant.now().getEpochSecond();
        ut1 -= ut1%86400;
        long daysAgo_time = (ut1) - daysAgo*86400;
        long after_time = daysAgo_time+ (3600 * startHour);
        long before_time = daysAgo_time+ (3600 * endHour);
        ArrayList<TimeStamp> TimeStamps =
                timeStampRepository.findTimeStampByResidentIdAndTimeStampAfterAndTimeStampBefore(residentId, after_time, before_time);

        LocalDateTime boundDateAndTime;
        boundDateAndTime = LocalDate.now().minusDays(daysAgo-1).atStartOfDay();
        LocalDateTime targetdayDataAndTime = LocalDate.now().minusDays(daysAgo).atStartOfDay();
        ZoneId zoneId = ZoneId.of("GMT");
        ZonedDateTime bound = ZonedDateTime.of(boundDateAndTime, zoneId);
        ZonedDateTime tagetDay = ZonedDateTime.of(targetdayDataAndTime, zoneId);

        ArrayList<SmartPlugEvent> microwave= smartPlugEventRepository.findByDeviceAliasAndDatetimeAfterAndDatetimeBefore
                ("Bob-microwave", tagetDay, bound);
        ArrayList<SmartPlugEvent> toaster= smartPlugEventRepository.findByDeviceAliasAndDatetimeAfterAndDatetimeBefore
                ("Bob-toaster", tagetDay, bound);

        int refrigeratorCheck=0;
        int platesCheck=0;
        int silverwareCheck=0;
        int toasterCheck=0;
        int microwaveCheck=0;
//        int totalCheck=0;
        long firstUse_silverware=0, firstUse_refrigerator=0;

        for(int i=0; i<microwave.size(); i++){
            if(microwave.get(i).getStatus().equals("in-use")){
                microwaveCheck ++;
//                totalCheck++;
            }
        }

        for(int i=0; i<toaster.size(); i++){
            if(toaster.get(i).getStatus().equals("in-use")){
                toasterCheck ++;
//                totalCheck++;
            }
        }

        for(int i=0; i<TimeStamps.size(); i++){
            if( (TimeStamps.get(i).getSensorId() == 18 || TimeStamps.get(i).getSensorId() ==17)){
                if(refrigeratorCheck ==0)
                    firstUse_refrigerator = TimeStamps.get(i).getTimeStamp();
//                else
//                    lastUse_refrigerator = TimeStamps.get(i).getTimeStamp();
                refrigeratorCheck ++;
            }
            if( (TimeStamps.get(i).getSensorId() == 12 || TimeStamps.get(i).getSensorId() == 13 ||
                    TimeStamps.get(i).getSensorId() == 14
                    || TimeStamps.get(i).getSensorId() == 15)) {
                platesCheck++;
            }
            if( TimeStamps.get(i).getSensorId() == 21){
                if(silverwareCheck == 0)
                    firstUse_silverware = TimeStamps.get(i).getTimeStamp();
//                else
//                    lastUse_refrigerator = TimeStamps.get(i).getTimeStamp();
                silverwareCheck++;
            }

        }

        boolean cookCheck = refrigeratorCheck !=0 && (platesCheck !=0 || silverwareCheck != 0) && (toasterCheck != 0 && microwaveCheck != 0);
        if(startHour == 0) {
            if (cookCheck) {
                eat.put("Dinner: ", "Cooked Food");
                String startTime = timeStamp2Date(firstUse_silverware).toString();
                eat.put("Start Time: ", startTime);
            } else if (refrigeratorCheck !=0 && (platesCheck !=0 || silverwareCheck != 0)) {
                eat.put("Dinner: ", "Frozen Food");
                String startTime = timeStamp2Date(firstUse_silverware).toString();
                eat.put("Start Time: ", startTime);
            } else {
                if(refrigeratorCheck !=0) {
                    eat.put("Dinner: ", "Opened Refrigerator, But not sure if he ate.");
                    String openTime = timeStamp2Date(firstUse_refrigerator).toString();
                    eat.put("Refrigerator Opened: ", openTime);
                }
                else{
                    eat.put("Dinner: ", "None");
                }
            }
        }
        else if(startHour == 16){
            if (cookCheck) {
                eat.put("Lunch: ", "Cooked Food");
                String startTime = timeStamp2Date(firstUse_silverware).toString();
                eat.put("Start Time: ", startTime);
            } else if (refrigeratorCheck !=0 && (platesCheck !=0 || silverwareCheck != 0)) {
                eat.put("Lunch: ", "Frozen Food");
                String startTime = timeStamp2Date(firstUse_silverware).toString();
                eat.put("Start Time: ", startTime);
            } else {
                if(refrigeratorCheck !=0) {
                    eat.put("Lunch: ", "Opened Refrigerator, But not sure if he ate.");
                    String openTime = timeStamp2Date(firstUse_refrigerator).toString();
                    eat.put("Refrigerator Opened: ", openTime);
                }
                else{
                    eat.put("Lunch: ", "None");
                }
            }
        }
        else if(startHour == 19){
            if (cookCheck) {
                eat.put("Dinner: ", "Cooked Food");
                String startTime = timeStamp2Date(firstUse_silverware).toString();
                eat.put("Start Time: ", startTime);
            } else if (refrigeratorCheck !=0 && (platesCheck !=0 || silverwareCheck != 0)) {
                eat.put("Dinner: ", "Frozen Food");
                String startTime = timeStamp2Date(firstUse_silverware).toString();
                eat.put("Start Time: ", startTime);
            } else {
                if(refrigeratorCheck !=0) {
                    eat.put("Dinner: ", "Opened Refrigerator, But not sure if he ate.");
                    String openTime = timeStamp2Date(firstUse_refrigerator).toString();
                    eat.put("Refrigerator Opened: ", openTime);
                }
                else{
                    eat.put("Dinner: ", "None");
                }
            }
        }

    }

    public ZonedDateTime timeStamp2Date(long timeStamp){
        Instant i = Instant.ofEpochSecond(timeStamp - 21600);
        ZoneId zoneId = ZoneId.of("GMT");
        ZonedDateTime answer = ZonedDateTime.ofInstant(i, zoneId);
        return answer;
    }

    public String getSensorContent(int sensorId){
        if( (sensorId == 18 || sensorId ==17)){
            return "Refrigerator";
        }
        else if((sensorId == 10 || sensorId ==11)){
            return "spices, jars, and tuber ware";
        }
        else if((sensorId == 12 || sensorId ==13)){
            return "ceramic bowls, Fancy glasses, Cooking spray";
        }
        else if((sensorId == 14 || sensorId ==15)){
            return "Glasses, Mugs, Cups, Bowls, Plates";
        }
        else if((sensorId == 16)){
            return "Pans";
        }
        else if((sensorId == 19)){
            return "Freezer";
        }
        else if((sensorId == 20)){
            return "Pantry";
        }
        else if((sensorId == 21)){
            return "Silverware";
        }
        else
            return "Unknown Sensor";
    }
}
