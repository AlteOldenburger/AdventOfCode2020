package de.mattes.ossenbeck.day.day02;

import de.mattes.ossenbeck.day.Executor;
import de.mattes.ossenbeck.day.InputReader;

public class Main {
    public static void main(String[] args) {
        var input = InputReader.read("dayTwo.txt");

        Executor.execute(new PasswordPolicyValidator(input));
    }
}