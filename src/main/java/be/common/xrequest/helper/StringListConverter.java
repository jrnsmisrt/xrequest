package be.common.xrequest.helper;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;

@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {
    private static final String SPLIT_CHAR = ", ";

    @Override
    public String convertToDatabaseColumn(List<String> stringList) {
        return stringList != null ? String.join(SPLIT_CHAR, stringList) : "";
    }

    @Override
    public List<String> convertToEntityAttribute(String string) {
        if (string != null) {
            String newString = string.replace("[", "");
            newString = newString.replace("]", "");
            newString = newString.replace("\"", "");

            return Arrays.asList(newString.split(SPLIT_CHAR));
        } else {
            return emptyList();
        }
    }
}
