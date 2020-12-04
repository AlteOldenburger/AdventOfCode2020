package de.justinharder.aoc.d02;

import de.justinharder.aoc.base.Input;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class Main
{
	public static void main(String[] args)
	{
		var inputD02 = Input.of(Path.of("src/main/resources/d02.txt"), StandardCharsets.UTF_8);
		var validPasswords = Validation.filter(PasswordStream.of(inputD02));
		System.out.println("Number of valid passwords: " + validPasswords.size()); // Result = 655
	}
}
