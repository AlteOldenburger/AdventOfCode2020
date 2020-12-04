package de.justinharder.aoc.d02;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Validation
{
	public static List<ValidPassword> filter(Stream<Password> passwords)
	{
		return passwords
			.filter(Validation::validate)
			.map(ValidPassword::of)
			.collect(Collectors.toList());
	}

	private static boolean validate(Password password)
	{
		var occurrences = 0;
		for (int i = 0; i < password.getValue().length(); i++)
		{
			if (password.getValue().charAt(i) == password.getPolicy().getLiteral())
			{
				occurrences++;
			}
		}

		return occurrences >= password.getPolicy().getMinimum() && occurrences <= password.getPolicy().getMaximum();
	}
}
