package de.mattes.ossenbeck.day.one;

import de.mattes.ossenbeck.day.InputConverter;
import de.mattes.ossenbeck.day.PuzzleSolver;

import java.util.List;

public class ExpenseReportRepairer implements PuzzleSolver {
    private static final int NO_RESULT = -1;
    private final int desiredSum;
    private final List<Integer> expenseReport;

    public ExpenseReportRepairer(int desiredSum, List<String> expenseReport) {
        this.desiredSum = desiredSum;
        this.expenseReport = InputConverter.convertToInt(expenseReport);
    }

    @Override
    public Integer solvePartOne() {
        return multiplyEntriesForDesiredSum(desiredSum);
    }

    @Override
    public Integer solvePartTwo() {
        return expenseReport.stream()
                            .filter(entry -> multiplyEntriesForDesiredSum(desiredSum - entry) != NO_RESULT)
                            .reduce(Math::multiplyExact)
                            .orElse(NO_RESULT);
    }

    private int multiplyEntriesForDesiredSum(int desiredSum) {
        return expenseReport.stream()
                            .filter(entry -> expenseReport.contains(desiredSum - entry))
                            .reduce(Math::multiplyExact)
                            .orElse(NO_RESULT);
    }
}