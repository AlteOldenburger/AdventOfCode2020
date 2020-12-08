package de.mattes.ossenbeck.day;

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
}