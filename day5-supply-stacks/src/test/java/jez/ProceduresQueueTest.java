package jez;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import jez.factories.ProceduresQueueFactory;

public class ProceduresQueueTest {
	@Test
	void build_from_factory() {
		ProceduresQueueFactory proceduresStackFactory = new ProceduresQueueFactory();
		
		String proceduresAString = "move 1 from 2 to 1\r\n" + //
				"move 3 from 1 to 3\r\n" + //
				"move 2 from 2 to 1\r\n" + //
				"move 1 from 1 to 2";
		ProceduresQueue procedures = proceduresStackFactory.build(proceduresAString);

		assertEquals(procedures.remove(), new Procedure(1, 2, 1));
		assertEquals(procedures.remove(), new Procedure(3, 1, 3));
		assertEquals(procedures.remove(), new Procedure(2, 2, 1));
		assertEquals(procedures.remove(), new Procedure(1, 1, 2));
	}
}
