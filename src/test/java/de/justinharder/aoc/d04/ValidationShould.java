package de.justinharder.aoc.d04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ValidationShould
{
	@Test
	@DisplayName("validate Passports (Part I)")
	void test01()
	{
		assertAll(
			() -> assertThat(Validation.ofOne(new Passport()
				.setEyeColor("gry")
				.setPassportId("860033327")
				.setExpirationYear("2020")
				.setHairColor("#fffffd")
				.setBirthYear("1937")
				.setIssueYear("2017")
				.setCountryId("147")
				.setHeight("183cm"))).isTrue(),
			() -> assertThat(Validation.ofOne(new Passport()
				.setIssueYear("2013")
				.setEyeColor("amb")
				.setCountryId("350")
				.setExpirationYear("2023")
				.setPassportId("028048884")
				.setHairColor("#cfa07d")
				.setBirthYear("1929"))).isFalse(),
			() -> assertThat(Validation.ofOne(new Passport()
				.setHairColor("#ae17e1")
				.setIssueYear("2013")
				.setExpirationYear("2024")
				.setEyeColor("brn")
				.setPassportId("760753108")
				.setBirthYear("1931")
				.setHeight("179cm"))).isTrue(),
			() -> assertThat(Validation.ofOne(new Passport()
				.setHairColor("#cfa07d")
				.setExpirationYear("2025")
				.setPassportId("166559648")
				.setIssueYear("2011")
				.setEyeColor("brn")
				.setHeight("59in"))).isFalse());
	}

	@Test
	@DisplayName("validate Passports (Part II)")
	void test02()
	{
		assertAll(
			() -> assertThat(Validation.ofTwo(new Passport()
				.setExpirationYear("1972")
				.setCountryId("100")
				.setHairColor("#18171d")
				.setEyeColor("amb")
				.setHeight("170")
				.setPassportId("186cm")
				.setIssueYear("2018")
				.setBirthYear("1926"))).isFalse(),
			() -> assertThat(Validation.ofTwo(new Passport()
				.setPassportId("087499704")
				.setHeight("74in")
				.setEyeColor("grn")
				.setIssueYear("2012")
				.setExpirationYear("2030")
				.setBirthYear("1980")
				.setHairColor("#623a2f"))).isTrue());
	}
}
