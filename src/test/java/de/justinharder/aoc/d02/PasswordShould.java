package de.justinharder.aoc.d02;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PasswordShould
{
	@Test
	@DisplayName("eine Wrapper-Klasse sein")
	void test01()
	{
		var policy = new PolicyOne('a', 1, 3);
		var password = new Password(policy, "aaabcd");

		assertAll(
			() -> assertThat(password.getPolicy()).isEqualTo(policy),
			() -> assertThat(password.getValue()).isEqualTo("aaabcd"),
			() -> assertThat(password)
				.hasToString("Password{policy=PolicyOne{literal=a, minimum=1, maximum=3}, value=aaabcd}"));
	}

	@Test
	@DisplayName("sich vergleichen")
	void test02()
	{
		EqualsVerifier.forClass(Password.class)
			.suppress(Warning.STRICT_INHERITANCE)
			.suppress(Warning.NULL_FIELDS)
			.verify();
	}
}
