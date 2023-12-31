package jez;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Application
{

	public static void main(String[] args) throws IOException, URISyntaxException
	{
		List<String> lines = Files.readAllLines(Path.of("./src/main/resources/input.txt"));

		var calibrationLines = lines.stream()
				.map(line -> CalibrationLine.of(line))
				.toList();

		var answer = calibrationLines.stream()
				.mapToInt(calibrationLine -> calibrationLine.getCalibrationValue())
				.sum();

		System.out.println(answer);
	}
}
