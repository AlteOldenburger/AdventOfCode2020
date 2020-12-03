package de.justinharder.aoc.base;

public class InputException extends RuntimeException
{
	private static final long serialVersionUID = 675099065717250877L;

	public InputException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
