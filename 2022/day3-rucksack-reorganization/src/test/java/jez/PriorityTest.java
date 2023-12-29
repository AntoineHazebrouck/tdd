package jez;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PriorityTest {
	@Test
	void priorities() {
		assertEquals(1, Priority.of('a'));
		assertEquals(2, Priority.of('b'));
		assertEquals(26, Priority.of('z'));
		
		assertEquals(27, Priority.of('A'));
		assertEquals(28, Priority.of('B'));
		assertEquals(52, Priority.of('Z'));
	}
}
