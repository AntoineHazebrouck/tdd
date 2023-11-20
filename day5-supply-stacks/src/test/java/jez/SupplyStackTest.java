package jez;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SupplyStackTest {
	@Test
	void build() {

		SupplyStack stack = new SupplyStack( 'Z', 'N');

		assertEquals('N', stack.pop());
		assertEquals('Z', stack.pop());
	}
}
