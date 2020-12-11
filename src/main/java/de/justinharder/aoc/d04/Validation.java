package de.justinharder.aoc.d04;

import java.util.List;

public class Validation
{
	private Validation() {}

	public static boolean ofOne(Passport passport)
	{
		return passport.getBirthYear() != null
			&& passport.getIssueYear() != null
			&& passport.getExpirationYear() != null
			&& passport.getHeight() != null
			&& passport.getHairColor() != null
			&& passport.getEyeColor() != null
			&& passport.getPassportId() != null;
	}

	public static boolean ofTwo(Passport passport)
	{
		return ofOne(passport)
			&& digits(passport.getBirthYear().getValue(), 4)
			&& between(passport.getBirthYear().getValue(), 1920, 2002)
			&& digits(passport.getIssueYear().getValue(), 4)
			&& between(passport.getIssueYear().getValue(), 2010, 2020)
			&& digits(passport.getExpirationYear().getValue(), 4)
			&& between(passport.getExpirationYear().getValue(), 2020, 2030)
			&& height(passport.getHeight().getValue())
			&& hairColor(passport.getHairColor().getValue())
			&& eyeColor(passport.getEyeColor().getValue())
			&& digits(passport.getPassportId().getValue(), 9);
	}

	private static boolean between(String value, int minimum, int maximum)
	{
		var number = Integer.parseInt(value);
		return number >= minimum && number <= maximum;
	}

	private static boolean digits(String value, int digits)
	{
		return value.length() == digits;
	}

	private static boolean eyeColor(String eyeColor)
	{
		return List.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(eyeColor);
	}

	private static boolean height(String height)
	{
		if (height.contains("cm"))
		{
			return between(height.substring(0, height.indexOf('c')), 150, 193);
		}
		if (height.contains("in"))
		{
			return between(height.substring(0, height.indexOf('i')), 59, 76);
		}
		return false;
	}

	private static boolean hairColor(String hairColor)
	{
		if (hairColor.length() != 7)
		{
			return false;
		}
		if (hairColor.charAt(0) != '#')
		{
			return false;
		}
		for (int i = 1; i < hairColor.length(); i++)
		{
			if (!List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f')
				.contains(hairColor.charAt(i)))
			{
				return false;
			}
		}
		return true;
	}
}
