package de.justinharder.aoc.d02;

import java.util.Objects;

public class PolicyOne extends Policy
{
	private final int minimum;
	private final int maximum;

	public PolicyOne(char literal, int minimum, int maximum)
	{
		super(literal);
		this.minimum = minimum;
		this.maximum = maximum;
	}

	public int getMinimum()
	{
		return minimum;
	}

	public int getMaximum()
	{
		return maximum;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof PolicyOne))
		{
			return false;
		}
		PolicyOne policyOne = (PolicyOne) o;
		return literal == policyOne.literal && minimum == policyOne.minimum && maximum == policyOne.maximum;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(minimum, maximum, literal);
	}

	@Override
	public String toString()
	{
		return "PolicyOne{literal=" + literal + ", minimum=" + minimum + ", maximum=" + maximum + "}";
	}
}
