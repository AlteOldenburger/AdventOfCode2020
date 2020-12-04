package de.justinharder.aoc.d02;

public class ValidPassword extends Password
{
	private ValidPassword(Policy policy, String value)
	{
		super(policy, value);
	}

	public static ValidPassword of(Password password)
	{
		return new ValidPassword(password.policy, password.value);
	}
}
