package de.mattes.ossenbeck.day.day06;

import de.mattes.ossenbeck.day.Executor;
import de.mattes.ossenbeck.day.InputReader;

public class Main {
    public static void main(String[] args) {
        var input = InputReader.read("day06.txt");

        Executor.execute(new CustomDeclarationFormEvaluator(input));
    }
}