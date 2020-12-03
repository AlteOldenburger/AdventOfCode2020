package de.justinharder.aoc.d01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TwentyTwentyShould
{
	private static final List<String> INPUT = List.of("1721", "979", "366", "299", "675", "1456");

	private TwentyTwenty sut;

	@BeforeEach
	void setup()
	{
		sut = new TwentyTwenty();
	}

	@Test
	@DisplayName("find the two entries that sum to 2020 and then multiply those two numbers together")
	void test01()
	{
		assertThat(sut.ofTwo(INPUT)).isEqualTo(514579);
	}

	@Test
	@DisplayName("find the three entries that sum to 2020 and then multiply those three numbers together")
	void test02()
	{
		assertThat(sut.ofThree(INPUT)).isEqualTo(241861950);
	}
}
