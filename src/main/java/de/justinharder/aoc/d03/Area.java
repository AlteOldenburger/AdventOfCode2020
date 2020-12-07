package de.justinharder.aoc.d03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Area
{
	private final Geology[][] geologyArray;

	private Area(Geology[][] geologyArray)
	{
		this.geologyArray = geologyArray;
	}

	public static Area of(List<String> input)
	{
		var map = input.stream()
			.map(line -> line.repeat(1000))
			.collect(Collectors.toList());

		var array = new Geology[map.size()][map.get(0).length()];
		for (int row = 0; row < map.size(); row++)
		{
			var line = map.get(row).chars()
				.mapToObj(character -> Geology.of((char) character))
				.collect(Collectors.toList());
			for (int column = 0; column < line.size(); column++)
			{
				array[row][column] = line.get(column);
			}
		}

		return new Area(array);
	}

	public Geology position(int row, int column)
	{
		return geologyArray[row][column];
	}

	public boolean isLastRow(int row)
	{
		return geologyArray.length == row + 1;
	}

	@Override
	public String toString()
	{
		return Arrays.deepToString(geologyArray);
	}
}
