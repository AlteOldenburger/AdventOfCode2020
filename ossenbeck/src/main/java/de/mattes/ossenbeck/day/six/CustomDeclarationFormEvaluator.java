package de.mattes.ossenbeck.day.six;

import de.mattes.ossenbeck.day.PuzzleSolver;
import de.mattes.ossenbeck.day.Util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static de.mattes.ossenbeck.day.Util.NO_RESULT;

public class CustomDeclarationFormEvaluator implements PuzzleSolver {
    private final List<String> groupAnswers;

    public CustomDeclarationFormEvaluator(List<String> groupAnswers) {
        this.groupAnswers = groupAnswers;
    }

    @Override
    public Number solvePartOne() {
        return identifyGroupAnswers(Util::union);
    }

    @Override
    public Number solvePartTwo() {
        return identifyGroupAnswers(Util::intersect);
    }

    public int identifyGroupAnswers(Function<? super List<String>, ? extends Set<String>> setOperation) {
        return Arrays.stream(String.join(";", groupAnswers).split(";;"))
                     .map(s -> Arrays.asList(s.split(";")))
                     .map(setOperation)
                     .map(Set::size)
                     .reduce(Integer::sum)
                     .orElse(NO_RESULT);
    }
}