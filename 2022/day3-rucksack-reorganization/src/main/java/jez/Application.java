package jez;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) throws IOException {
		String path =
				"C:\\Users\\Jez\\Desktop\\travail\\cours\\BUT3\\tdd\\day3-rucksack-reorganization\\src\\main\\ressources\\input.txt";
		String fileAsString = new String(Files.readAllBytes(Paths.get(path)));

		Scanner scanner = new Scanner(fileAsString);

		Integer count = 0;
		while (scanner.hasNextLine()) {
			String line1 = scanner.nextLine();
			String line2 = scanner.nextLine();
			String line3 = scanner.nextLine();

			Group group = new Group(line1, line2, line3);

			count += Priority.of(group.sharedByAllThree());
		}
		System.out.println(count);
	}
}
