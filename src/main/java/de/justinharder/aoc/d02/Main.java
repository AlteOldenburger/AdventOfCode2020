package de.justinharder.aoc.d02;

import de.justinharder.aoc.base.Input;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class Main
{
	public static void main(String[] args)
	{
		var input = Input.of(Path.of("src/main/resources/d02.txt"), StandardCharsets.UTF_8);
		var passwordsOne = Validation.filter(PasswordStream.of(input, PasswordStream::mapOne), Validation::validateOne);
		System.out.println("Number of passwords (Part I): " + passwordsOne.size()); // Result = 655
		var passwordsTwo = Validation.filter(PasswordStream.of(input, PasswordStream::mapTwo), Validation::validateTwo);
		System.out.println("Number of passwords (Part II): " + passwordsTwo.size()); // Result = 673
	}
}
