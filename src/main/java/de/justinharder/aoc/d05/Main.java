package de.justinharder.aoc.d05;

import de.justinharder.aoc.base.Input;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Main
{
	public static void main(String[] args)
	{
		var seats = Input.of(Path.of("src/main/resources/d05.txt")).stream()
			.map(BinarySpacePartitioning::map)
			.map(BinarySpacePartitioning::decode);

		System.out.println("The highest Seat is: " + seats.mapToInt(Seat::getSeatId).max().getAsInt()); // Result = 888

		var seatIds = Input.of(Path.of("src/main/resources/d05.txt")).stream()
			.map(BinarySpacePartitioning::map)
			.map(BinarySpacePartitioning::decode)
			.mapToInt(Seat::getSeatId)
			.sorted()
			.boxed()
			.collect(Collectors.toList());

		System.out.println("My SeatID is: " + findMissingSeatId(seatIds)); // Result = 522
	}

	private static int findMissingSeatId(List<Integer> seatIds)
	{
		for (int i = seatIds.get(0); i < seatIds.size(); i++)
		{
			int current = seatIds.get(i);
			int next = seatIds.get(i + 1);
			if ((next - current) > 1)
			{
				return current + 1;
			}
		}

		return 0;
	}
}
