package de.justinharder.aoc.d04;

import java.util.stream.Stream;

public enum PassportKeys
{
	BIRTH_YEAR("byr"),
	ISSUE_YEAR("iyr"),
	EXPIRATION_YEAR("eyr"),
	HEIGHT("hgt"),
	HAIR_COLOR("hcl"),
	EYE_COLOR("ecl"),
	PASSPORT_ID("pid"),
	COUNTRY_ID("cid");

	private final String key;

	PassportKeys(String key)
	{
		this.key = key;
	}

	public static PassportKeys of(String key)
	{
		return Stream.of(values())
			.filter(passportKey -> passportKey.key.equals(key))
			.findAny()
			.orElseThrow();
	}

	@Override
	public String toString()
	{
		return key;
	}
}
