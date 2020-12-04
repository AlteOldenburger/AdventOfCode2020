package de.justinharder.aoc.d02;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Password
{
	protected final Policy policy;
	protected final String value;

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
