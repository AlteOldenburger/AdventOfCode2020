package de.mattes.ossenbeck.day.four;

import de.mattes.ossenbeck.day.PuzzleSolver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PassportValidator implements PuzzleSolver {
    private final List<String> input;

    public PassportValidator(List<String> input) {
        this.input = input;
    }

    @Override
    public Number solvePartOne() {
        return createListOfPassports().size();
    }

    @Override
    public Number solvePartTwo() {
        return createListOfPassports().stream()
                                      .filter(Passport::isValid)
                                      .count();
    }

    private List<Passport> createListOfPassports() {
        return cleanInput()
                .map(Passport::of)
                .filter(Passport::hasAllRequiredFields)
                .collect(Collectors.toList());
    }

    private Stream<String[]> cleanInput() {
        return Arrays.stream(String.join(";", input).split(";;"))
                     .map(s -> s.replace(" ", ";").split(";"));
    }
}