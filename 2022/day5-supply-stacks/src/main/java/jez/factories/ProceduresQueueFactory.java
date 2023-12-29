package jez.factories;

import jez.ProceduresQueue;

public class ProceduresQueueFactory {
	private final ProcedureFactory factory = new ProcedureFactory();

	public ProceduresQueue build(String procedures) {
		ProceduresQueue stack = new ProceduresQueue();
		for (String procedure : procedures.split("\r\n")) {
			stack.add(factory.build(procedure));
		}
		return stack;
	}

}
