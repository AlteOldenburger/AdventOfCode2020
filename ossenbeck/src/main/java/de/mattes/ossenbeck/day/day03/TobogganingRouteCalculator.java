package de.mattes.ossenbeck.day.day03;

import de.mattes.ossenbeck.day.PuzzleSolver;
import de.mattes.ossenbeck.day.Util;

import java.util.List;
import java.util.stream.IntStream;

public class TobogganingRouteCalculator implements PuzzleSolver {
    private static final long NO_RESULT = Util.NO_RESULT;

    private final Forest forest;

    public TobogganingRouteCalculator(List<String> mapOfForest) {
        this.forest = new Forest(mapOfForest);
    }

    @Override
    public Number solvePartOne() {
        return countTreeEncountersWith(new Coordinate(3, 1));
    }

    @Override
    public Number solvePartTwo() {
        return List.of(new Coordinate(1, 1),
                       new Coordinate(3, 1),
                       new Coordinate(5, 1),
                       new Coordinate(7, 1),
                       new Coordinate(1, 2))
                   .stream()
                   .map(this::countTreeEncountersWith)
                   .reduce(Math::multiplyExact)
                   .orElse(NO_RESULT);
    }

    private Long countTreeEncountersWith(Coordinate direction) {
        var toboggan = new Toboggan();
        return IntStream.range(1, forest.getHeight())
                        .peek(ignore -> toboggan.move(direction))
                        .filter(ignore -> forest.isTreeAt(toboggan.getPosition()))
                        .count();
    }
}