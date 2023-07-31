package be.common.xrequest.helper;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Converter
public class CustomLocalDateTimeConverter implements AttributeConverter<LocalDateTime, String> {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    @Override
    public String convertToDatabaseColumn(LocalDateTime localDateTime) {
        if (localDateTime != null) {
            return localDateTime.format(dateTimeFormatter);
        } else {
            return "";
        }
    }

    @Override
    public LocalDateTime convertToEntityAttribute(String s) {
        if (s != null) {
            return LocalDateTime.parse(s, dateTimeFormatter);
        } else {
            return LocalDateTime.now();
        }

    }
}
