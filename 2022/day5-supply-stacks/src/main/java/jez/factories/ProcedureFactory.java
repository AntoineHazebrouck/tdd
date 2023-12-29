package jez.factories;

import jez.Procedure;

public class ProcedureFactory {

	public Procedure build(String procedure) {
		String stripped = procedure.replace("move ", "").replace(" from ", " ").replace(" to ", " ");
		String[] split = stripped.split(" ");
		int nbCratesToMove = Integer.parseInt(split[0]);
		int from = Integer.parseInt(split[1]);
		int to = Integer.parseInt(split[2]);
		return new Procedure(nbCratesToMove, from, to);
	}

}
