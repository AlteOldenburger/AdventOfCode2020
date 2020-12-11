package de.justinharder.aoc.d04;

import de.justinharder.aoc.base.Input;

import java.nio.file.Path;

public class Main
{
	public static void main(String[] args)
	{
		var input = String.join("\n", Input.of(Path.of("src/main/resources/d04.txt")));
		System.out.println("Number of Passports (Part I): " + PassportStream.of(input).filter(Validation::ofOne)
			.count()); // Result = 210
		System.out.println("Number of Passports (Part II): " + PassportStream.of(input).filter(Validation::ofTwo)
			.count()); // Result = 131
	}
}
