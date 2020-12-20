package de.justinharder.aoc.d05;

import java.util.stream.Stream;

public enum Direction
{
	FRONT('F'),
	BACK('B'),
	LEFT('L'),
	RIGHT('R');

	private final char character;

	Direction(char character)
	{
		this.character = character;
	}

	public static Direction of(char character)
	{
		return Stream.of(values())
			.filter(direction -> direction.character == character)
			.findAny()
			.orElseThrow();
	}
}
