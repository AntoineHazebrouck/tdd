package jez;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Application
{

	public static void main(String[] args) throws IOException
	{
		String path = "src\\main\\resources\\input.txt";
		String file = new String(Files.readAllBytes(Paths.get(path)));
		// String file = "mjqjpqmgbljsphdztnvjfqwrcgsmlb";

		PaquetChecker paquetChecker = new PaquetChecker();
		DatastreamIterator datastreamIterator = new DatastreamIterator(file, 14);

		System.out.println(getIndex(paquetChecker, datastreamIterator));
	}

	private static Integer getIndex(PaquetChecker paquetChecker,
			DatastreamIterator datastreamIterator)
	{
		Integer index = 14;
		while (datastreamIterator.hasNext())
		{
			String paquet = datastreamIterator.next();
			if (paquetChecker.check(paquet))
			{
				return index;
			}
			index++;
		}
		return -1;
	}
}
