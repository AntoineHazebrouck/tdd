package jez;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CalorieCounterTest {
	@Test
	void building_from_empty_string() {
		CalorieCounter count = CalorieCounter.build("");

		assertTrue(count.isEmpty());
	}

	@Test
	void counting_total_from_a_single_line() {
		String input = "8417";

		CalorieCounter count = CalorieCounter.build(input);

		assertEquals(Integer.parseInt(input), count.all());
	}

	@Test
	void counting_total_from_several_lines() {
		String input = "1000\r\n" + //
				"2000\r\n" + //
				"3000\r\n" + //
				"4000\r\n" + //
				"5000\r\n" + //
				"6000\r\n" + //
				"7000\r\n" + //
				"8000";
		// 36 000

		CalorieCounter count = CalorieCounter.build(input);

		assertEquals(36000, count.all());
	}

	@Test
	void counting_total_from_several_elves() {
		String input = "9000\r\n" + //
				"4000\r\n" + //
				"\r\n" + //
				"4000\r\n" + //
				"2000";

		CalorieCounter count = CalorieCounter.build(input);

		assertEquals(19000, count.all());
	}

	@Test
	void counting_elf_by_elf() {
		String input = "5000\r\n" + //
				"4000\r\n" + //
				"\r\n" + //
				"18000\r\n" + //
				"3000\r\n" + //
				"16000\r\n" + //
				"\r\n" + //
				"6000\r\n" + //
				"2000\r\n" + //
				"13000\r\n" + //
				"5000\r\n" + //
				"2000\r\n" + //
				"12000\r\n" + //
				"\r\n" + //
				"5000\r\n" + //
				"5000";

		CalorieCounter count = CalorieCounter.build(input);

		assertEquals(List.of(9000, 37000, 40000, 10000), count.elfByElf());
	}
}
