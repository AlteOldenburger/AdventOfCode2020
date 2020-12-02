package de.brachwitz.leon.tag01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseSupportErrorInvestigator
{
    public Integer solvePart1(Integer expectedSum, List<Integer> numbers)
    {
        var values = findEntryWithSum(expectedSum, numbers);
        return values
                .values()
                .stream()
                .reduce(1, (a, b) -> a * b);
    }

    public Integer solvePart2(Integer expectedSum, List<Integer> numbers)
    {
        var result = 0;
        for (Integer value : numbers)
        {
            final var tmpValues = findEntryWithSum(expectedSum - value, numbers);
            if (!tmpValues.isEmpty())
            {
                result = tmpValues
                        .values()
                        .stream()
                        .reduce(1, (x, y) -> x * y) * value;
                break;
            }
        }
        return result;
    }

    private Map<Integer, Integer> findEntryWithSum(Integer expectetdSum, List<Integer> numbers)
    {
        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < numbers.size(); i++)
        {
            for (int j = 0; j < numbers.size() - 1; j++)
            {
                var sum = numbers.get(i) + numbers.get(j);
                if (sum == expectetdSum)
                {
                    result.put(i, numbers.get(i));
                }
            }
        }
        return result;
    }
}