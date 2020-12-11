package de.mattes.ossenbeck.day.six;

import de.mattes.ossenbeck.day.Executor;
import de.mattes.ossenbeck.day.InputReader;

public class Main {
    public static void main(String[] args) {
        var input = InputReader.read("daySix.txt");

        Executor.execute(new CustomDeclarationFormEvaluator(input));
    }
}