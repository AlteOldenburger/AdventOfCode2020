package de.justinharder.aoc.d02;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Validation
{
	private Validation() {}

	public static List<Password> filter(Stream<Password> passwords, Predicate<Password> validate)
	{
		return passwords
			.filter(validate)
			.collect(Collectors.toList());
	}

	public static boolean validateOne(Password password)
	{
		var occurrences = password.getValue().chars()
			.filter(literal -> literal == password.getPolicy().getLiteral())
			.count();

		return occurrences >= ((PolicyOne) password.getPolicy()).getMinimum() &&
			occurrences <= ((PolicyOne) password.getPolicy()).getMaximum();
	}

	public static boolean validateTwo(Password password)
	{
		var policy = (PolicyTwo) password.getPolicy();
		var literal = policy.getLiteral();
		var value = password.getValue();

		return value.charAt(policy.getFirstPosition()) == literal ^ value.charAt(policy.getSecondPosition()) == literal;
	}
}
