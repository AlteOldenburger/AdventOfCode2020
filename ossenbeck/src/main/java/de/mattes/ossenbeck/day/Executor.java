package de.mattes.ossenbeck.day;

public class Executor {

    private Executor() {}

    public static void execute(PuzzleSolver puzzleSolver) {
        System.out.println(puzzleSolver.solvePartOne());
        System.out.println(puzzleSolver.solvePartTwo());
    }
}