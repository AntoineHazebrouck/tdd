package jez;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RucksackTest {
	@Test
	void building_from_a_string() {

		String input = "vJrwpWtwJgWrhcsFMMfFFhFp";
		Rucksack rucksack = Rucksack.of(input);

		assertEquals(input.length(), rucksack.length());
	}

	@Test
	void getting_compartments() {
		String input = "vJrwpWtwJgWrhcsFMMfFFhFp";
		Rucksack rucksack = Rucksack.of(input);

		assertEquals("vJrwpWtwJgWr", rucksack.getLeftCompartment().toString());
		assertEquals("hcsFMMfFFhFp", rucksack.getRightCompartment().toString());
	}
	
	@Test
	void appears_in_both_compartments() {
		String input = "vJrwpWtwJgWrhcsFMMfFFhFp";
		Rucksack rucksack = Rucksack.of(input);

		assertEquals('p', rucksack.getLeftCompartment().sharesAnyOf(rucksack.getRightCompartment()));
		
		input = "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL";
		rucksack = Rucksack.of(input);
		
		assertEquals('L', rucksack.getLeftCompartment().sharesAnyOf(rucksack.getRightCompartment()));
	}
}
