package de.justinharder.aoc.d04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class PassportStreamShould
{
	@Test
	@DisplayName("map the input into a Stream<Password>")
	void test01()
	{
		assertThat(PassportStream.of(
			"ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\n" +
				"byr:1937 iyr:2017 cid:147 hgt:183cm\n" +
				"\n" +
				"iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884\n" +
				"hcl:#cfa07d byr:1929\n" +
				"\n" +
				"hcl:#ae17e1 iyr:2013\n" +
				"eyr:2024\n" +
				"ecl:brn pid:760753108 byr:1931\n" +
				"hgt:179cm\n" +
				"\n" +
				"hcl:#cfa07d eyr:2025 pid:166559648\n" +
				"iyr:2011 ecl:brn hgt:59in")).containsExactlyInAnyOrder(new Passport()
				.setEyeColor("gry")
				.setPassportId("860033327")
				.setExpirationYear("2020")
				.setHairColor("#fffffd")
				.setBirthYear("1937")
				.setIssueYear("2017")
				.setCountryId("147")
				.setHeight("183cm"),
			new Passport()
				.setIssueYear("2013")
				.setEyeColor("amb")
				.setCountryId("350")
				.setExpirationYear("2023")
				.setPassportId("028048884")
				.setHairColor("#cfa07d")
				.setBirthYear("1929"),
			new Passport()
				.setHairColor("#ae17e1")
				.setIssueYear("2013")
				.setExpirationYear("2024")
				.setEyeColor("brn")
				.setPassportId("760753108")
				.setBirthYear("1931")
				.setHeight("179cm"),
			new Passport()
				.setHairColor("#cfa07d")
				.setExpirationYear("2025")
				.setPassportId("166559648")
				.setIssueYear("2011")
				.setEyeColor("brn")
				.setHeight("59in"));
	}
}
