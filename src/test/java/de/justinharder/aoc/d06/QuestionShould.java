package de.justinharder.aoc.d06;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class QuestionShould
{
	@Test
	@DisplayName("union two Sets")
	void test01()
	{
		var stream1 = Stream.of('a', 'b', 'c');
		var stream2 = Stream.of('a', 'd');
		var result = Question.union(stream1, stream2);

		assertThat(result).containsExactlyInAnyOrder('a', 'b', 'c', 'd');
	}

	@Test
	@DisplayName("intersect two Sets")
	void test02()
	{
		var stream1 = Stream.of('a', 'b', 'c');
		var stream2 = Stream.of('a', 'd');
		var result = Question.intersect(stream1, stream2);

		assertThat(result).containsExactlyInAnyOrder('a');
	}

	@Test
	@DisplayName("map the input with union")
	void test03()
	{
		var result = Question.ofInput("abc\n" +
				"\n" +
				"a\n" +
				"b\n" +
				"c\n" +
				"\n" +
				"ab\n" +
				"ac\n" +
				"\n" +
				"a\n" +
				"a\n" +
				"a\n" +
				"a\n" +
				"\n" +
				"b",
			Question::union);

		assertThat(result).containsExactlyInAnyOrder(
			Set.of('a', 'b', 'c'),
			Set.of('a', 'b', 'c'),
			Set.of('a', 'b', 'c'),
			Set.of('a'),
			Set.of('b'));
	}

	@Test
	@DisplayName("map the input with intersect")
	void test04()
	{
		var result = Question.ofInput("abc\n" +
				"\n" +
				"a\n" +
				"b\n" +
				"c\n" +
				"\n" +
				"ab\n" +
				"ac\n" +
				"\n" +
				"a\n" +
				"a\n" +
				"a\n" +
				"a\n" +
				"\n" +
				"b",
			Question::intersect);

		assertThat(result).containsExactlyInAnyOrder(
			Set.of('a', 'b', 'c'),
			new HashSet<>() {},
			Set.of('a'),
			Set.of('a'),
			Set.of('b'));
	}
}
