package com.sddec.Model;

import javax.persistence.Converter;
import javax.persistence.AttributeConverter;
import java.time.Duration;

@Converter
public class DurationToStringConverter implements AttributeConverter<Duration, String>
{

    @Override
    public String convertToDatabaseColumn(Duration duration)
    {
        return duration == null ? null : duration.toString();
    }

    @Override
    public Duration convertToEntityAttribute(String dbData)
    {
        return dbData == null ? null : Duration.parse(dbData);
    }
}
