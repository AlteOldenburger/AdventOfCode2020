package de.mattes.ossenbeck.day.one;

import de.mattes.ossenbeck.day.Executor;
import de.mattes.ossenbeck.day.InputReader;

public class Main {
    public static void main(String[] args) {
        var input = InputReader.readInput("dayOne.txt");

        Executor.execute(new ExpenseReportRepairer(2020, input));
    }
}