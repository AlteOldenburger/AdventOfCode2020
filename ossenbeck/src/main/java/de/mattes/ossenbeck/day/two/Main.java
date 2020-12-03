package de.mattes.ossenbeck.day.two;

import de.mattes.ossenbeck.day.Executor;
import de.mattes.ossenbeck.day.InputReader;

public class Main {
    public static void main(String[] args) {
        var input = InputReader.readInput("dayTwo.txt");

        Executor.execute(new PasswordPolicyValidator(input));
    }
}