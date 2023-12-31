package jez;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import jez.entities.Operation;

public class Application
{

	public static void main(String[] args) throws IOException
	{
		List<String> lines = Files.readAllLines(Path.of("./src/main/resources/input.txt"));

		// first operation
		Operation previousOperation = Operation.noOperation()
				.withCurrentCycle(1)
				.withCurrentX(1)
				.build();
		for (int lineIndex = 1; lineIndex < lines.size(); lineIndex++)
		{
			String line = lines.get(lineIndex);

			Operation currentOperation;

			if (line.contains("noop"))
			{
				currentOperation = previousOperation.next(
															Operation.noOperation());
			} else
			{
				currentOperation = previousOperation.next(
															Operation.addX()
																	.withV(Integer.parseInt(line
																			.split(" ")[1])));
			}

			System.out.println(previousOperation);

			previousOperation = currentOperation;
		}
		// lines.forEach(line -> System.out.println(line));
	}
}
