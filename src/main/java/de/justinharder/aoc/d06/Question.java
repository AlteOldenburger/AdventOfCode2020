package de.justinharder.aoc.d06;

import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Question
{
	private Question() {}

	public static Stream<Set<Character>> ofInput(String input, BinaryOperator<Stream<Character>> combination)
	{
		return Stream.of(input.split("\n\n"))
			.map(block -> Stream.of(block.split("\n")).map(Question::decode)
				.reduce(combination)
				.get()
				.collect(Collectors.toSet()));
	}

	public static Stream<Character> union(Stream<Character> stream1, Stream<Character> stream2)
	{
		var set1 = stream1.collect(Collectors.toSet());
		set1.addAll(stream2.collect(Collectors.toSet()));
		return set1.stream();
	}

	public static Stream<Character> intersect(Stream<Character> stream1, Stream<Character> stream2)
	{
		var set1 = stream1.collect(Collectors.toSet());
		set1.retainAll(stream2.collect(Collectors.toSet()));
		return set1.stream();
	}

	private static Stream<Character> decode(String line)
	{
		return line.chars().mapToObj(integer -> (char) integer);
	}
}
