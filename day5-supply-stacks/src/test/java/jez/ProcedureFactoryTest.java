package jez;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import jez.factories.ProcedureFactory;

public class ProcedureFactoryTest {
	@Test
	void build_from_factory() {
		ProcedureFactory procedureFactory = new ProcedureFactory();

		Procedure procedure = procedureFactory.build("move 1 from 2 to 5");

		assertEquals(1, procedure.getNbCratesToMove());
		assertEquals(2, procedure.from());
		assertEquals(5, procedure.to());
	}
}
