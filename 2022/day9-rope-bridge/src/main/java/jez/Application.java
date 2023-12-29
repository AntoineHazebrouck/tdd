package jez;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Application
{

	public static void main(String[] args) throws IOException
	{
		String path = "src\\main\\resources\\input.txt";
		String file = new String(Files.readAllBytes(Paths.get(path)));
		List<String> lines = Arrays.asList(file.split("\\r\\n"));
	}
}
