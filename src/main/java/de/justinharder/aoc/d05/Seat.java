package de.justinharder.aoc.d05;

import java.util.Objects;

public class Seat
{
	private final int row;
	private final int column;
	private final int seatId;

	public Seat(int row, int column)
	{
		this.row = row;
		this.column = column;
		this.seatId = calculateSeatId(row, column);
	}

	private int calculateSeatId(int row, int column)
	{
		return row * 8 + column;
	}

	public int getSeatId()
	{
		return seatId;
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
		Seat seat = (Seat) o;
		return row == seat.row && column == seat.column && seatId == seat.seatId;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(row, column, seatId);
	}

	@Override
	public String toString()
	{
		return "Seat{row=" + row + ", column=" + column + ", seatId=" + seatId + "}";
	}
}
