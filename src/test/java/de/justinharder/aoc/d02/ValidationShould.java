package de.justinharder.aoc.d02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ValidationShould
{
	@Test
	@DisplayName("filter all valid Passwords")
	void test01()
	{
		var passwords = Stream.of(
			new Password(new Policy(1, 3, 'a'), "abcde"),
			new Password(new Policy(1, 3, 'b'), "cdefg"),
			new Password(new Policy(2, 9, 'c'), "ccccccccc"));

		assertThat(Validation.filter(passwords)).containsExactly(
			new Password(new Policy(1, 3, 'a'), "abcde"),
			new Password(new Policy(2, 9, 'c'), "ccccccccc"));
	}
}
