package de.mattes.ossenbeck.day;

import java.util.List;
import java.util.stream.Collectors;

public class InputConverter {

    private InputConverter() {}

    public static List<Integer> convertToInt(List<String> inputToConvert) {
        return inputToConvert.stream()
                             .map(Integer::valueOf)
                             .collect(Collectors.toList());
    }
}