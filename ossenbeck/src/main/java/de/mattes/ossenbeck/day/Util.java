package de.mattes.ossenbeck.day;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Util {
    public static final int NO_RESULT = -1;

    private Util() {}

    public static boolean isANumberAndBetween(String numberAsString, int min, int max) {
        try {
            var number = Integer.parseInt(numberAsString);
            return number >= min && number <= max;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidHeight(String height) {
        if (height.contains("cm")) {
            return isANumberAndBetween(height.substring(0, height.indexOf("c")), 150, 193);
        } else if (height.contains("in")) {
            return isANumberAndBetween(height.substring(0, height.indexOf("i")), 59, 76);
        }
        return false;
    }

    public static Set<String> union(List<String> arr) {
        return arr.stream()
                  .flatMap(s -> Arrays.stream(s.split("")))
                  .collect(Collectors.toSet());
    }

    public static Set<String> intersect(List<String> arr) {
        var set = new HashSet<>(List.of(arr.get(0).split("")));

        arr.stream()
           .skip(1)
           .map(s -> List.of(s.split("")))
           .map(HashSet::new)
           .forEach(set::retainAll);

        return set;
    }
}