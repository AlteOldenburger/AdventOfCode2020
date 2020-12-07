package de.justinharder.aoc.d01;

import de.justinharder.aoc.base.Input;

import java.nio.file.Path;

public class Main
{
	public static void main(String[] args)
	{
		var inputD01 = Input.of(Path.of("src/main/resources/d01.txt"));
		var twentyTwenty = new TwentyTwenty();
		System.out.println("2020 with 2 numbers: " + twentyTwenty.ofTwo(inputD01)); // Result = 713184
		System.out.println("2020 with 3 numbers: " + twentyTwenty.ofThree(inputD01)); // Result = 261244452
	}
}
