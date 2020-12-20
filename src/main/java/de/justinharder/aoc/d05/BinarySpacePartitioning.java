package de.justinharder.aoc.d05;

import java.util.List;
import java.util.stream.Collectors;

public class BinarySpacePartitioning
{
	private BinarySpacePartitioning() {}

	public static List<Direction> map(String line)
	{
		return line.chars()
			.mapToObj(character -> Direction.of((char) character))
			.collect(Collectors.toList());
	}

	public static Seat decode(List<Direction> directions)
	{
		var minRow = 0;
		var maxRow = 127;
		var minColumn = 0;
		var maxColumn = 7;

		for (var direction : directions)
		{
			if (direction.equals(Direction.FRONT))
			{
				maxRow = lowerHalf(minRow, maxRow);
			}
			if (direction.equals(Direction.BACK))
			{
				minRow = upperHalf(minRow, maxRow);
			}
			if (direction.equals(Direction.LEFT))
			{
				maxColumn = lowerHalf(minColumn, maxColumn);
			}
			if (direction.equals(Direction.RIGHT))
			{
				minColumn = upperHalf(minColumn, maxColumn);
			}
		}

		return new Seat(maxRow, maxColumn);
	}

	public static int lowerHalf(int min, int max)
	{
		return middle(min, max);
	}

	public static int upperHalf(int min, int max)
	{
		return middle(min, max) + 1;
	}

	private static int middle(int min, int max)
	{
		return (min + max) / 2;
	}
}
