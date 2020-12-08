package de.mattes.ossenbeck.day.five;

import de.mattes.ossenbeck.day.Executor;
import de.mattes.ossenbeck.day.InputReader;

public class Main {
    public static void main(String[] args) {
        var input = InputReader.read("dayFive.txt");

        Executor.execute(new SeatDecoder(input));
    }
}