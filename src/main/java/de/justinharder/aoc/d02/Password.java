package de.justinharder.aoc.d02;

import java.util.Objects;

public class Password
{
	private final Policy policy;
	private final String value;

	public Password(Policy policy, String value)
	{
		this.policy = policy;
		this.value = value;
	}

	public Policy getPolicy()
	{
		return policy;
	}

	public String getValue()
	{
		return value;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof Password))
		{
			return false;
		}
		Password password = (Password) o;
		return policy.equals(password.policy) && value.equals(password.value);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(policy, value);
	}

	@Override
	public String toString()
	{
		return "Password{policy=" + policy + ", value=" + value + "}";
	}
}
