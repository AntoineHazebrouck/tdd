package jez;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jez.factories.ProceduresQueueFactory;

public class Application
{

	public static void main(String[] args) throws IOException
	{
		String path =
				"C:\\Users\\Jez\\Desktop\\travail\\cours\\BUT3\\tdd\\day5-supply-stacks\\src\\main\\ressources\\input.txt";
		String fileAsString = new String(Files.readAllBytes(Paths.get(path)));
		List<String> stacks =
				new ArrayList<>(List.of(fileAsString.split("\r\n\r\n")[0].split("\r\n")));
		String procedures = fileAsString.split("\r\n\r\n")[1];

		ProceduresQueueFactory proceduresQueueFactory = new ProceduresQueueFactory();
		// SupplyStackFactory supplyStackFactory = new SupplyStackFactory();

		ProceduresQueue proceduresQueue = proceduresQueueFactory.build(procedures);

		Collections.reverse(stacks);

		Integer nbStacks = getNbStacks(stacks);


		stacks.forEach(line -> {
			System.out.println(line);
		});

		System.out.println(nbStacks);
		// System.out.println(nbStacks);
	}

	private static int getNbStacks(List<String> stacks)
	{
		return Integer.parseInt("" + stacks.get(0).charAt(stacks.get(0).length() - 2));
	}
}
