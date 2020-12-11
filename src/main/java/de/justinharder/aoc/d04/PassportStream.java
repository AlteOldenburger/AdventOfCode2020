package de.justinharder.aoc.d04;

import java.util.stream.Stream;

public class PassportStream
{
	private PassportStream() {}

	public static Stream<Passport> of(String input)
	{
		return Stream.of(input.split("\n\n"))
			.map(PassportStream::mapPassport);
	}

	private static Passport mapPassport(String block)
	{
		var builder = new Passport.Builder();
		Stream.of(block.split("[ \\n]+"))
			.map(PassportStream::mapField)
			.forEach(builder::with);
		return builder.build();
	}

	private static Field mapField(String pair)
	{
		return new Field(
			PassportKeys.of(pair.substring(0, pair.indexOf(':'))),
			pair.substring(pair.indexOf(':') + 1));
	}
}
