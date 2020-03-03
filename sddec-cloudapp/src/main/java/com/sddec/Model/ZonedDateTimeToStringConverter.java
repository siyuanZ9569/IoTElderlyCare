package com.sddec.Model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Converter
public class ZonedDateTimeToStringConverter implements AttributeConverter<ZonedDateTime, String>
{

    @Override
    public String convertToDatabaseColumn(ZonedDateTime time)
    {
        if (time == null) {
            return null;
        }

        ZoneId UTC = ZoneId.of("UTC");

        ZonedDateTime timeUTC = time.withZoneSameInstant(UTC);

        return timeUTC.toString();
    }

    @Override
    public ZonedDateTime convertToEntityAttribute(String dbData)
    {
        if (dbData == null) {
            return null;
        }
        else {
            ZoneId UTC = ZoneId.of("UTC");
            ZoneId Central = ZoneId.of("America/Chicago");

            ZonedDateTime time_UTC = null;

            //try parsing string as a UTC timestamp
            try {
                 time_UTC = ZonedDateTime.parse(dbData);
            }

            //if string is formatted as yyyy-mm-dd HH:mm:ss
            catch (java.time.format.DateTimeParseException e) {
                LocalDateTime localTime = LocalDateTime.parse(dbData, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                time_UTC = localTime.atZone(UTC);

            }



            //return Central time
            return time_UTC.withZoneSameInstant(Central);
        }

    }
}
