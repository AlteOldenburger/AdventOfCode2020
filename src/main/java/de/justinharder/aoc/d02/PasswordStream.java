package de.justinharder.aoc.d02;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class PasswordStream
{
	private PasswordStream() {}

	public static Stream<Password> of(List<String> input, Function<String, Password> mapper)
	{
		return input.stream().map(mapper);
	}

	public static Password mapOne(String line)
	{
		// TODO: Regex 
		return new Password(
			new PolicyOne(
				line.charAt(line.indexOf(':') - 1),
				Integer.parseInt(line.substring(0, line.indexOf('-'))),
				Integer.parseInt(line.substring(line.indexOf('-') + 1, line.indexOf(' ')))),
			line.substring(line.indexOf(':') + 2));
	}

	public static Password mapTwo(String line)
	{
		// TODO: Regex
		return new Password(
			new PolicyTwo(
				line.charAt(line.indexOf(':') - 1),
				Integer.parseInt(line.substring(0, line.indexOf('-'))) - 1,
				Integer.parseInt(line.substring(line.indexOf('-') + 1, line.indexOf(' '))) - 1),
			line.substring(line.indexOf(':') + 2));
	}
}
