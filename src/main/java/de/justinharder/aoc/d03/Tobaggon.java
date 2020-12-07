package de.justinharder.aoc.d03;

public class Tobaggon
{
	private final int right;
	private final int down;

	public Tobaggon(int right, int down)
	{
		this.right = right;
		this.down = down;
	}

	public int traverse(Area area)
	{
		var row = 0;
		var column = 0;
		var numberOfTrees = 0;

		while (!area.isLastRow(row))
		{
			row += down;
			column += right;

			if (area.position(row, column) == Geology.TREE)
			{
				numberOfTrees++;
			}
		}

		return numberOfTrees;
	}
}
