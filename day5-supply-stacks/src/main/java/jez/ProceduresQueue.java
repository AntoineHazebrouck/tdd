package jez;

import java.util.LinkedList;
import java.util.Queue;

public class ProceduresQueue {
	private final Queue<Procedure> procedures = new LinkedList<>();

	public void add(Procedure procedure) {
		procedures.add(procedure);
	}

	public Procedure remove() {
		return procedures.remove();
	}
}
