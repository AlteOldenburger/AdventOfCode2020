package de.mattes.ossenbeck.day.one;

import de.mattes.ossenbeck.day.InputReader;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        var input = InputReader.readInput("dayOne.txt");
        var repairer = new ExpenseReportRepairer(2020, input);

       System.out.println(repairer.solvePartOne());
       System.out.println(repairer.solvePartTwo());
    }
}
