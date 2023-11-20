package jez;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import jez.factories.AssignmentPairFactory;

public class AssignmentPairTest {
	@Test
	void factory_an_assignement() {
		AssignmentPairFactory factory = new AssignmentPairFactory();

		AssignmentPair assignmentPair = factory.getAssignmentPair("2-4,6-8");

		assertEquals(new Range(2, 4), assignmentPair.getLeft());
		assertEquals(new Range(6, 8), assignmentPair.getRight());
	}
}
