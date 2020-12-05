package de.justinharder.aoc.base;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Input
{
	private Input() {}

	public static List<String> of(Path path, Charset charset)
	{
		try
		{
			return Files.readAllLines(path, charset);
		}
		catch (IOException e)
		{
			throw new InputException("Path \"" + path + "\" is invalid!", e);
		}
	}
}
