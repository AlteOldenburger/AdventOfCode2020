package de.brachwitz.leon.tag02;

import java.util.List;
import java.util.regex.Pattern;

public class PasswordPolicyChecker
{
    private final static String PATTERN = "(^\\d+)-(\\d+) (\\w): (\\w+)";

    public Integer checkPassword(List<String> input)
    {
        var pattern = Pattern.compile(PATTERN);
        var validPasswords = 0;
        for (String line : input)
        {
            var m = pattern.matcher(line);
            m.matches();
            var minimumNumbersOfCharacters = Integer.parseInt(m.group(1));
            var maximumNumbersOfCharacters = Integer.parseInt(m.group(2));
            var character = m.group(3).charAt(0);
            var password = m.group(4);

            var occurrences = password.chars().filter(chars -> chars == character).count();

            if (occurrences >= minimumNumbersOfCharacters && occurrences <= maximumNumbersOfCharacters)
            {
                validPasswords++;
            }
        }
        return validPasswords;
    }
}
