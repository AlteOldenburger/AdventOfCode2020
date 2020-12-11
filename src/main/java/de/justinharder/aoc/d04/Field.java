package de.justinharder.aoc.d04;

import java.util.Objects;

public class Field
{
	private final PassportKeys key;
	private final String value;

	public Field(PassportKeys key, String value)
	{
		this.key = key;
		this.value = value;
	}

	public PassportKeys getKey()
	{
		return key;
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
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		Field field = (Field) o;
		return Objects.equals(key, field.key) && Objects.equals(value, field.value);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(key, value);
	}

	@Override
	public String toString()
	{
		return key + ":" + value;
	}
}
