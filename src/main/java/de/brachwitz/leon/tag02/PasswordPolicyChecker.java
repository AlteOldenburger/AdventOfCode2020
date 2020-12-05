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
            var characterToMatch = m.group(3).charAt(0);
            var password = m.group(4);

            var occurrences = password.chars().filter(chars -> chars == characterToMatch).count();
            var a = password.charAt(minimumNumbersOfCharacters - 1);
            var b = password.charAt(maximumNumbersOfCharacters - 1);

            if (characterToMatch == a)
            {
                if (characterToMatch != b)
                {
                    validPasswords++;
                }
            }
            if (characterToMatch == b)
            {
                if (characterToMatch != 1)
                {
                    validPasswords++;
                }
            }
        }
        return validPasswords;
    }
}
