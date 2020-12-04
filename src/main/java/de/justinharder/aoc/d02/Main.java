package de.justinharder.aoc.d02;

import de.justinharder.aoc.base.Input;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class Main
{
	public static void main(String[] args)
	{
		var input = Input.of(Path.of("src/main/resources/d02.txt"), StandardCharsets.UTF_8);
		var passwords = Validation.filter(PasswordStream.of(input));
		System.out.println("Number of passwords: " + passwords.size()); // Result = 655
	}
}
