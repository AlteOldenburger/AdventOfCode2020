package de.justinharder.aoc.d02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationShould
{
	@Test
	@DisplayName("filter all valid Passwords for PolicyOne")
	void test01()
	{
		var passwords = Stream.of(
			new Password(new PolicyOne('a', 1, 3), "abcde"),
			new Password(new PolicyOne('b', 1, 3), "cdefg"),
			new Password(new PolicyOne('c', 2, 9), "ccccccccc"));

		assertThat(Validation.filter(passwords, Validation::validateOne)).containsExactly(
			new Password(new PolicyOne('a', 1, 3), "abcde"),
			new Password(new PolicyOne('c', 2, 9), "ccccccccc"));
	}
}
