package de.justinharder.aoc.d02;

import java.util.Objects;

public class PolicyTwo extends Policy
{
	private final int firstPosition;
	private final int secondPosition;

	public PolicyTwo(char literal, int firstPosition, int secondPosition)
	{
		super(literal);
		this.firstPosition = firstPosition;
		this.secondPosition = secondPosition;
	}

	public int getFirstPosition()
	{
		return firstPosition;
	}

	public int getSecondPosition()
	{
		return secondPosition;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof PolicyTwo))
		{
			return false;
		}
		PolicyTwo policyTwo = (PolicyTwo) o;
		return literal == policyTwo.literal && firstPosition == policyTwo.firstPosition && secondPosition == policyTwo.secondPosition;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(firstPosition, secondPosition);
	}

	@Override
	public String toString()
	{
		return "PolicyTwo{literal=" + literal + ", firstPosition=" + firstPosition + ", secondPosition=" + secondPosition + "}";
	}
}
