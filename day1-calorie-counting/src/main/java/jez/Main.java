package jez;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		String path =
				"C:\\Users\\Jez\\Desktop\\travail\\cours\\BUT3\\tdd\\day1-calorie-counting\\src\\main\\ressources\\input.txt";
		String fileAsString = new String(Files.readAllBytes(Paths.get(path)));

		CalorieCounter count = CalorieCounter.build(fileAsString);

		List<Integer> counts = count.elfByElf();

		counts.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer arg0, Integer arg1) {
				return arg1.compareTo(arg0);
			}

		});

		System.out.println(counts.get(0) + counts.get(1) + counts.get(2));
	}
}
