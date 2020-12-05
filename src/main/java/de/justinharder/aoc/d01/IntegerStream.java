package de.justinharder.aoc.d01;

import java.util.List;
import java.util.stream.IntStream;

public class IntegerStream
{
	private IntegerStream() {}

	public static IntStream of(List<String> input)
	{
		return input.stream().mapToInt(Integer::valueOf);
	}
}
