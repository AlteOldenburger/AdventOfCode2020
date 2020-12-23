package de.justinharder.aoc.d06;

import de.justinharder.aoc.base.Input;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;

public class Main
{
	public static void main(String[] args)
	{
		var input = String.join("\n", Input.of(Path.of("src/main/resources/d06.txt")));

		System.out.println("The sum of Questions is (Part I): " + Question.ofInput(input, Question::union)
			.map(ArrayList::new)
			.mapToLong(Collection::size)
			.sum()); // Result = 6742

		System.out.println("The sum of Questions is (Part II): " + Question.ofInput(input, Question::intersect)
			.map(ArrayList::new)
			.mapToLong(Collection::size)
			.sum()); // Result = 3447
	}
}
