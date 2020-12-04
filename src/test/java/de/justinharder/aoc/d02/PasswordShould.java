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
		var policy = new Policy(1, 3, 'a');
		var password = new Password(policy, "aaabcd");

		assertAll(
			() -> assertThat(password.getPolicy()).isEqualTo(policy),
			() -> assertThat(password.getValue()).isEqualTo("aaabcd"),
			() -> assertThat(password)
				.hasToString("Password{policy=Policy{minimum=1, maximum=3, literal=a}, value=aaabcd}"));
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
