package jez;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application
{

	public static void main(String[] args) throws IOException
	{
		String path = "src\\main\\resources\\input.txt";
		String file = new String(Files.readAllBytes(Paths.get(path)));
		List<String> lines = Arrays.asList(file.split("\\r\\n"));

		List<Tree> trees = new ArrayList<>();
		int row = 0;
		int column = 0;
		for (String line : lines)
		{
			for (Character character : line.toCharArray())
			{
				trees.add(new Tree(Integer.parseInt("" + character), row, column));

				column++;
			}
			row++;
			column = 0;
		}

		Forest forest = Forest.link(trees);

		System.out.println(forest.getVisibleTrees()
				.size());

		System.out.println(forest.getTrees()
				.stream()
				.mapToInt(tree -> tree.scenicScore())
				.max()
				.getAsInt());
	}
}
