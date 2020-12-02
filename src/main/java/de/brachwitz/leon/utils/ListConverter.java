package de.brachwitz.leon.utils;

import java.util.List;
import java.util.stream.Collectors;

public class ListConverter
{
    public List<Integer> convertInputListToIntegerList(List<String> input)
    {
        return input.stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList());
    }
}
