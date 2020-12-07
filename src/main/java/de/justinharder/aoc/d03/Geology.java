package de.justinharder.aoc.d03;

import java.util.stream.Stream;

public enum Geology
{
	SQUARE('.'),
	TREE('#');

	private final char literal;

	Geology(char literal)
	{
		this.literal = literal;
	}

	public static Geology of(char literal)
	{
		return Stream.of(values())
			.filter(geology -> geology.literal == literal)
			.findAny()
			.orElseThrow();
	}

	@Override
	public String toString()
	{
		return String.valueOf(literal);
	}
}
