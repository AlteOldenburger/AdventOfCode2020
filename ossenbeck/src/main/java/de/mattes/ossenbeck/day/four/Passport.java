package de.mattes.ossenbeck.day.four;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static de.mattes.ossenbeck.day.Util.isANumberAndBetween;
import static de.mattes.ossenbeck.day.Util.isValidHeight;

public class Passport {
    private static final int NUMBER_OF_REQUIRED_FIELDS = 7;
    private final List<PassportField> fields;

    private Passport(List<PassportField> fields) {
        this.fields = fields;
    }

    public static Passport of(String[] batchFile) {
        return new Passport(
                Arrays.stream(batchFile)
                      .map(s -> s.split(":"))
                      .map(Passport::fieldFromString)
                      .collect(Collectors.toList())
        );
    }

    public boolean hasAllRequiredFields() {
        return fields.stream()
                     .filter(PassportField::isRequired)
                     .count() == NUMBER_OF_REQUIRED_FIELDS;
    }

    public boolean isValid() {
        return fields.stream()
                     .allMatch(PassportField::isValid);
    }

    private static PassportField fieldFromString(String[] keyAndValue) {
        var key = keyAndValue[0];
        var value = keyAndValue[1];

        return switch (key) {
            case "byr" -> new birthYear(value);
            case "iyr" -> new issueYear(value);
            case "eyr" -> new expirationYear(value);
            case "pid" -> new passportId(value);
            case "cid" -> new countryId(value);
            case "hgt" -> new height(value);
            case "hcl" -> new hairColor(value);
            case "ecl" -> new eyeColor(value);
            default -> throw new FieldNotFoundException(key);
        };
    }
}

record birthYear(String year) implements PassportField {
    @Override public boolean isRequired() {
        return true;
    }
    @Override public boolean isValid() {
        return isANumberAndBetween(year, 1920, 2002);
    }
}

record issueYear(String year) implements PassportField {
    @Override public boolean isRequired() {
        return true;
    }
    @Override public boolean isValid() {
        return isANumberAndBetween(year, 2010, 2020);
    }
}

record expirationYear(String year) implements PassportField {
    @Override public boolean isRequired() {
        return true;
    }
    @Override public boolean isValid() {
        return isANumberAndBetween(year, 2020, 2030);
    }
}

record height(String value) implements PassportField {
    @Override public boolean isRequired() {
        return true;
    }
    @Override public boolean isValid() {
        return isValidHeight(value);
    }
}

record hairColor(String color) implements PassportField {
    private static final Pattern HEX_PATTERN = Pattern.compile("#\\p{XDigit}{6}");
    @Override public boolean isRequired() {
        return true;
    }
    @Override public boolean isValid() {
        return HEX_PATTERN.matcher(color).matches();
    }
}

record eyeColor(String color) implements PassportField {
    private static final Pattern EYE_PATTERN = Pattern.compile("amb|blu|brn|gry|grn|hzl|oth");
    @Override public boolean isRequired() {
        return true;
    }
    @Override public boolean isValid() {
        return EYE_PATTERN.matcher(color).matches();
    }
}

record passportId(String value) implements PassportField {
    private static final Pattern PID_PATTERN = Pattern.compile("\\d{9}");
    @Override public boolean isRequired() {
        return true;
    }
    @Override public boolean isValid() {
        return PID_PATTERN.matcher(value).matches();
    }
}

record countryId(String value) implements PassportField {
    @Override public boolean isRequired() {
        return false;
    }
    @Override public boolean isValid() {
        return true;
    }
}