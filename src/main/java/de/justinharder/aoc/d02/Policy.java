package de.justinharder.aoc.d02;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Policy
{
	private final int minimum;
	private final int maximum;
	private final char literal;

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
