package de.mattes.ossenbeck.day.day05;

import de.mattes.ossenbeck.day.Executor;
import de.mattes.ossenbeck.day.InputReader;

public class Main {
    public static void main(String[] args) {
        var input = InputReader.read("day05.txt");

        Executor.execute(new SeatDecoder(input));
    }
}