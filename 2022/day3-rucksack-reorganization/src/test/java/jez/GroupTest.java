package jez;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GroupTest {
	@Test
	void get_three_rucksacks_from_group() {
		String groupString = "vJrwpWtwJgWrhcsFMMfFFhFp\r\n" + //
				"jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\r\n" + //
				"PmmdzqPrVvPwwTWBwg";

		Group group = new Group(groupString);

		assertEquals("vJrwpWtwJgWrhcsFMMfFFhFp", group.getFirstRucksack().toString());
		assertEquals("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", group.getSecondRucksack().toString());
		assertEquals("PmmdzqPrVvPwwTWBwg", group.getThirdRucksack().toString());
	}

	@Test
	void priority_of_group() {
		String groupString = "vJrwpWtwJgWrhcsFMMfFFhFp\r\n" + //
				"jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\r\n" + //
				"PmmdzqPrVvPwwTWBwg";

		Group group = new Group(groupString);

		assertEquals(18, Priority.of(group.sharedByAllThree()));
	}
}
