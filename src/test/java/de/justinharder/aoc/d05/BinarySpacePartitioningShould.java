package de.justinharder.aoc.d05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BinarySpacePartitioningShould
{
	@Test
	@DisplayName("map a line into a List<Direction>")
	void test01()
	{
		assertThat(BinarySpacePartitioning.map("FBFBBFFRLR")).isEqualTo(
			List.of(Direction.FRONT, Direction.BACK, Direction.FRONT, Direction.BACK, Direction.BACK, Direction.FRONT,
				Direction.FRONT, Direction.RIGHT, Direction.LEFT, Direction.RIGHT));
	}

	@Test
	@DisplayName("decode a line into a Seat")
	void test02()
	{
		assertAll(
			() -> assertThat(BinarySpacePartitioning.decode(BinarySpacePartitioning.map("FBFBBFFRLR")))
				.isEqualTo(new Seat(44, 5)),
			() -> assertThat(BinarySpacePartitioning.decode(BinarySpacePartitioning.map("BFFFBBFRRR")))
				.isEqualTo(new Seat(70, 7)),
			() -> assertThat(BinarySpacePartitioning.decode(BinarySpacePartitioning.map("FFFBBBFRRR")))
				.isEqualTo(new Seat(14, 7)),
			() -> assertThat(BinarySpacePartitioning.decode(BinarySpacePartitioning.map("BBFFBBFRLL")))
				.isEqualTo(new Seat(102, 4)));
	}

	@Test
	@DisplayName("calculate the lower half of two numbers")
	void test03()
	{
		assertAll(
			() -> assertThat(BinarySpacePartitioning.lowerHalf(0, 127)).isEqualTo(63),
			() -> assertThat(BinarySpacePartitioning.lowerHalf(32, 63)).isEqualTo(47),
			() -> assertThat(BinarySpacePartitioning.lowerHalf(4, 7)).isEqualTo(5));
	}

	@Test
	@DisplayName("calculate the upper half of two numbers")
	void test04()
	{
		assertAll(
			() -> assertThat(BinarySpacePartitioning.upperHalf(0, 63)).isEqualTo(32),
			() -> assertThat(BinarySpacePartitioning.upperHalf(32, 47)).isEqualTo(40),
			() -> assertThat(BinarySpacePartitioning.upperHalf(0, 7)).isEqualTo(4));
	}
}
