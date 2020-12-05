package de.justinharder.aoc.d02;

import java.util.List;
import java.util.stream.Stream;

public class PasswordStream
{
	private PasswordStream() {}

	public static Stream<Password> of(List<String> input)
	{
		return input.stream().map(PasswordStream::map);
	}

	private static Password map(String line)
	{
		// TODO: Regex 
		return new Password(
			new Policy(
				Integer.parseInt(line.substring(0, line.indexOf('-'))),
				Integer.parseInt(line.substring(line.indexOf('-') + 1, line.indexOf(' '))),
				line.charAt(line.indexOf(':') - 1)),
			line.substring(line.indexOf(':') + 2));
	}
}
