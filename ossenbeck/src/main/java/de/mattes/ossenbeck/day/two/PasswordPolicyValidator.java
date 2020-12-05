package de.mattes.ossenbeck.day.two;

import de.mattes.ossenbeck.day.PuzzleSolver;

import java.util.ArrayList;
import java.util.List;

public class PasswordPolicyValidator implements PuzzleSolver {
    private final List<Password> passwords;

    public PasswordPolicyValidator(List<String> input) {
        passwords = convert(input);
    }

    @Override
    public Number solvePartOne() {
        return passwords.stream()
                        .filter(this::compliesOldPolicies)
                        .count();
    }

    @Override
    public Number solvePartTwo() {
        return passwords.stream()
                        .filter(this::compliesNewPolicies)
                        .count();
    }

    private List<Password> convert(List<String> input) {
        var listOfPasswords = new ArrayList<Password>();
        input.forEach(s -> {
            var minOcc = Integer.parseInt(s.substring(0, s.indexOf('-')));
            var maxOcc = Integer.parseInt(s.substring(s.indexOf('-') + 1, s.indexOf(' ')));
            var policyChar = s.charAt(s.indexOf(':') - 1);
            var text = s.substring(s.lastIndexOf(' '));

            listOfPasswords.add(new Password(text, new Policy(minOcc, maxOcc, policyChar)));
        });

        return listOfPasswords;
    }

    private boolean compliesOldPolicies(Password password) {
        var occurrence = password.text().chars()
                                 .filter(c -> c == password.policy().policyChar())
                                 .count();

        return occurrence >= password.policy().minOccurrence()
                && occurrence <= password.policy().maxOccurrence();
    }

    private boolean compliesNewPolicies(Password password) {
        var min = password.policy().minOccurrence();
        var max = password.policy().maxOccurrence();
        var policyChar = password.policy().policyChar();

        return password.text().charAt(min) == policyChar
                ^ password.text().charAt(max) == policyChar;
    }
}