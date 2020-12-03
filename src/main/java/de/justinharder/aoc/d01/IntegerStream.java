package de.justinharder.aoc.d01;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.IntStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IntegerStream
{
	public static IntStream of(List<String> input)
	{
		return input.stream().mapToInt(Integer::valueOf);
	}
}
