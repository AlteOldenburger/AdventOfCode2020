package de.brachwitz.leon.tag01;

import de.brachwitz.leon.utils.FileReader;
import de.brachwitz.leon.utils.ListConverter;

public class Main
{
    private static final Integer EXPECTED_SUM = 2020;

    public static void main(String[] args)
    {
        var fileReader = new FileReader();
        var listConverter = new ListConverter();
        var numbers = listConverter.convertInputListToIntegerList(fileReader.readCsvFile("/tag01/input.csv"));

        var expenseSupportErrorInvestigator = new ExpenseSupportErrorInvestigator();

        System.out.println(expenseSupportErrorInvestigator.solvePart1(EXPECTED_SUM, numbers));
        System.out.println(expenseSupportErrorInvestigator.solvePart2(EXPECTED_SUM, numbers));
    }
}
