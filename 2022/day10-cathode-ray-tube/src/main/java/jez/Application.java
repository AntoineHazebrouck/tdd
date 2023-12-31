package jez;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Application
{

	public static void main(String[] args) throws IOException
	{
		List<String> lines = Files.readAllLines(Path.of("./src/main/resources/input.txt"));

		lines.forEach(line -> System.out.println(line));
	}
}
