package de.justinharder.aoc.d02;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Validation
{
	private Validation() {}

	public static List<Password> filter(Stream<Password> passwords)
	{
		return passwords
			.filter(Validation::validate)
			.collect(Collectors.toList());
	}

	private static boolean validate(Password password)
	{
		var occurrences = password.getValue().chars()
			.filter(literal -> literal == password.getPolicy().getLiteral())
			.count();

		return occurrences >= password.getPolicy().getMinimum() && occurrences <= password.getPolicy().getMaximum();
	}
}
