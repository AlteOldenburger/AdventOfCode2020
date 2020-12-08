package de.mattes.ossenbeck.day.four;

import de.mattes.ossenbeck.day.Executor;
import de.mattes.ossenbeck.day.InputReader;

public class Main {
    public static void main(String[] args) {
        var input = InputReader.read("dayFour.txt");

        Executor.execute(new PassportValidator(input));
    }
}