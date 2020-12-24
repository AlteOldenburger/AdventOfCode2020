package de.mattes.ossenbeck.day.day05;

import de.mattes.ossenbeck.day.PuzzleSolver;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static de.mattes.ossenbeck.day.Util.NO_RESULT;

public class SeatDecoder implements PuzzleSolver {
    private final List<String> boardingPasses;

    public SeatDecoder(List<String> boardingPasses) {
        this.boardingPasses = boardingPasses;
    }

    @Override
    public Number solvePartOne() {
        return createListOfSeatIds().stream()
                                    .reduce(Integer::max)
                                    .orElse(NO_RESULT);
    }

    @Override
    public Number solvePartTwo() {
        var seatIds = createListOfSeatIds();
        var firstSeatId = seatIds.get(0);

        return IntStream.range(firstSeatId, seatIds.size() + firstSeatId)
                        .filter(i -> !seatIds.contains(i))
                        .findFirst()
                        .orElse(NO_RESULT);
    }

    private List<Integer> createListOfSeatIds() {
        return boardingPasses.stream()
                             .map(this::decode)
                             .map(this::binaryStringToInt)
                             .collect(Collectors.toList());
    }

    private String decode(String seat) {
        return seat.replaceAll("[F|L]", "0")
                   .replaceAll("[B|R]", "1");
    }

    private int binaryStringToInt(String binary) {
        return Integer.parseInt(binary, 2);
    }
}