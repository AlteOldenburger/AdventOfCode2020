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
		var fullMap = input.stream()
			.map(line -> line.repeat(1000))
			.collect(Collectors.toList());

		var array = new Geology[fullMap.size()][fullMap.get(0).length()];
		for (int i = 0; i < fullMap.size(); i++)
		{
			var geologyLine = fullMap.get(i).chars()
				.mapToObj(character -> Geology.of((char) character))
				.collect(Collectors.toList());
			for (int j = 0; j < geologyLine.size(); j++)
			{
				array[i][j] = geologyLine.get(j);
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
