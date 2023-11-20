package jez;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class RackTest {
	@Test
	void build() {
		Rack rack = new Rack(9);

		assertEquals(9, rack.size());
	}

	@Test
	void appending_lines() {
		String stacksAsString = " 1   2   3   4   5   6   7   8   9 \r\n" + //
				"[Z] [G] [J] [J] [W] [S] [H] [S] [G]\r\n" + //
				"[T] [W] [N] [R] [F] [R] [B] [J] [P]\r\n" + //
				"[F] [M] [H] [C] [S] [T] [N] [N] [N]\r\n" + //
				"[R]     [G] [N] [B] [D] [C] [M] [W]\r\n" + //
				"[W]         [W] [G] [V] [D] [G] [C]\r\n" + //
				"[J]             [Q] [W] [Z] [C] [J]\r\n" + //
				"[G]             [V] [C] [G]     [D]\r\n" + //
				"                [M]     [V]     [L]\r\n";

		List<String> stacks = new ArrayList<>(List.of(stacksAsString.split("\r\n")));
		stacks = stacks.subList(1, stacks.size());
		Rack rack = new Rack(9);

		for (int properIndex = 1, mapIndex = 1; properIndex <= 9 * 4; properIndex += 4, mapIndex ++) {
			for (String line : stacks) {
				if (line.charAt(mapIndex) != ' ') {
					rack.get(mapIndex).push(line.charAt(properIndex));
				}
				// System.out.println(line.charAt(index));
			}
		}

		assertEquals(new SupplyStack('Z', 'T', 'F', 'R', 'W', 'J', 'G'), rack.get(1));
		assertEquals(new SupplyStack(
				'S',
				'J',
				'N',
				'M',
				'G',
				'C'), rack.get(8));
		assertEquals(new SupplyStack(
				'G',
				'P',
				'N',
				'W',
				'C',
				'J',
				'D',
				'L'), rack.get(9));

	}
}
