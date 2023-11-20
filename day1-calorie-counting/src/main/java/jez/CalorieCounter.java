package jez;

import java.util.ArrayList;
import java.util.List;

public class CalorieCounter {
	private final String input;

	public CalorieCounter(String input) {
		this.input = input;
	}

	public static CalorieCounter build(String input) {
		return new CalorieCounter(input);
	}

	public boolean isEmpty() {
		return input.isEmpty();
	}

	public Integer all() {
		int count = 0;
		for (String line : input.split("\r\n")) {

			if (!line.isBlank()) {
				count += Integer.parseInt(line);
			}
		}
		return count;
	}

	public List<Integer> elfByElf() {
		List<Integer> counts = new ArrayList<>();

		int count = 0;
		for (String line : input.split("\r\n")) {


			if (!line.isBlank()) {
				count += Integer.parseInt(line);
			} else {
				counts.add(count);
				count = 0;
			}
		}
		counts.add(count);
		return counts;
		
	}

}
