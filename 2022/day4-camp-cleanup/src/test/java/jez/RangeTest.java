package jez;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import jez.factories.RangeFactory;

public class RangeTest {
	@Test
	void factory_a_range() {
		RangeFactory factory = new RangeFactory();

		Range range = factory.getRange("2-4");

		assertEquals(2, range.start());
		assertEquals(4, range.end());
	}

	@Test
	void range_contains_another() {
		Range container = new Range(2, 8);

		Range contained = new Range(3, 7);

		assertTrue(container.contains(contained));

		container = new Range(4, 6);

		contained = new Range(6, 6);

		assertTrue(container.contains(contained));
	}

	@Test
	void range_is_contained_by_another() {
		Range container = new Range(2, 8);

		Range contained = new Range(3, 7);

		assertTrue(contained.isContainedBy(container));

		container = new Range(4, 6);

		contained = new Range(6, 6);

		assertTrue(contained.isContainedBy(container));
	}

	@Test
	void range_overlaps_another() {
		RangeFactory factory = new RangeFactory();
		assertTrue(factory.getRange("5-7").overlaps(factory.getRange("7-9")));
		assertTrue(factory.getRange("7-9").overlaps(factory.getRange("5-7")));
		assertTrue(factory.getRange("2-8").overlaps(factory.getRange("3-7")));
		assertTrue(factory.getRange("6-6").overlaps(factory.getRange("4-6")));
		assertTrue(factory.getRange("2-6").overlaps(factory.getRange("4-8")));

		assertFalse(factory.getRange("2-4").overlaps(factory.getRange("6-8")));
		assertFalse(factory.getRange("2-3").overlaps(factory.getRange("4-5")));
	}
}
