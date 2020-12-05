package de.justinharder.aoc.d02;

public abstract class Policy
{
	protected final char literal;

	protected Policy(char literal)
	{
		this.literal = literal;
	}

	public char getLiteral()
	{
		return literal;
	}
}
