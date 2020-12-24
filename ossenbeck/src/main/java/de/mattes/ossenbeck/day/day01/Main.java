package de.mattes.ossenbeck.day.day01;

import de.mattes.ossenbeck.day.Executor;
import de.mattes.ossenbeck.day.InputReader;

public class Main {
    public static void main(String[] args) {
        var input = InputReader.read("day01.txt");

        Executor.execute(new ExpenseReportRepairer(2020, input));
    }
}