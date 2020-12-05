package de.justinharder.aoc.d01;

import java.util.List;

public class TwentyTwenty
{
	private int number1;
	private int number2;
	private int number3;

	public TwentyTwenty() {}

	public int ofTwo(List<String> input)
	{
		IntegerStream.of(input).forEach(entry1 -> {
			var difference = 2020 - entry1;
			if (IntegerStream.of(input).anyMatch(entry2 -> entry2 == difference))
			{
				this.number1 = entry1;
				this.number2 = difference;
			}
		});

		return Product.of(number1, number2);
	}

	public int ofThree(List<String> input)
	{
		IntegerStream.of(input).forEach(entry1 -> {
			var difference = 2020 - entry1;
			IntegerStream.of(input).forEach(entry2 -> {
				var anotherDifference = difference - entry2;
				if (IntegerStream.of(input).anyMatch(entry3 -> entry3 == anotherDifference))
				{
					this.number1 = entry1;
					this.number2 = entry2;
					this.number3 = anotherDifference;
				}
			});
		});

		return Product.of(number1, number2, number3);
	}
}
