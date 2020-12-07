package de.justinharder.aoc.d03;

import de.justinharder.aoc.base.Input;

import java.nio.file.Path;

public class Main
{
	public static void main(String[] args)
	{
		var input = Input.of(Path.of("src/main/resources/d03.txt"));
		var area = Area.of(input);

		var numberOfTrees1 = new Tobaggon(1, 1).traverse(area);
		var numberOfTrees2 = new Tobaggon(3, 1).traverse(area);
		var numberOfTrees3 = new Tobaggon(5, 1).traverse(area);
		var numberOfTrees4 = new Tobaggon(7, 1).traverse(area);
		var numberOfTrees5 = new Tobaggon(1, 2).traverse(area);
		System.out.println("Number of encountered Trees (1, 1): " + numberOfTrees1); // Result = 63
		System.out.println("Number of encountered Trees (3, 1): " + numberOfTrees2); // Result = 254
		System.out.println("Number of encountered Trees (5, 1): " + numberOfTrees3); // Result = 62
		System.out.println("Number of encountered Trees (7, 1): " + numberOfTrees4); // Result = 56
		System.out.println("Number of encountered Trees (1, 2): " + numberOfTrees5); // Result = 30

		System.out.println("Product of all five traverses: "
			+ numberOfTrees1 * numberOfTrees2 * numberOfTrees3 * numberOfTrees4 * numberOfTrees5); // Result = 1666768320
	}
}
