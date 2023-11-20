package jez;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Application {
	public static void main(String[] args) throws IOException {
		Game game = new Game();
		String path = "C:\\Users\\Jez\\Desktop\\travail\\cours\\BUT3\\tdd\\day2-rock-paper-scissors\\src\\main\\ressources\\input.txt";
		String fileAsString = new String(Files.readAllBytes(Paths.get(path)));

		int totalScore = 0;
		for (String line : fileAsString.split("\r\n")) {
			Signs opponent = Signs.of(line.split(" ")[0]);

			String you = line.split(" ")[1];


			totalScore += game.getScore(opponent, opponent.computeRequiredSign(you));
		}

		System.out.println(totalScore);
	}
}
