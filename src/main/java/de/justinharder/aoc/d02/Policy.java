package de.justinharder.aoc.d02;

import java.util.Objects;

public class Policy
{
	private final int minimum;
	private final int maximum;
	private final char literal;

	public Policy(int minimum, int maximum, char literal)
	{
		this.minimum = minimum;
		this.maximum = maximum;
		this.literal = literal;
	}

	public int getMinimum()
	{
		return minimum;
	}

	public int getMaximum()
	{
		return maximum;
	}

	public char getLiteral()
	{
		return literal;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof Policy))
		{
			return false;
		}
		Policy policy = (Policy) o;
		return minimum == policy.minimum && maximum == policy.maximum && literal == policy.literal;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(minimum, maximum, literal);
	}

	@Override
	public String toString()
	{
		return "Policy{minimum=" + minimum + ", maximum=" + maximum + ", literal=" + literal + "}";
	}
}
