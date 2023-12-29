package jez;

public enum Signs {
	ROCK("A"),
	PAPER("B"),
	SCISSORS("C");

	private String opponent;

	/**
	 * @return the opponent
	 */
	public String getOpponent() {
		return opponent;
	}

	public Signs winsOver() {
		if (this == ROCK) {
			return SCISSORS;
		} else if (this == PAPER) {
			return ROCK;
		} else if (this == SCISSORS) {
			return PAPER;
		}
		return null;
	}

	public Signs losesTo() {
		if (this == ROCK) {
			return PAPER;
		} else if (this == PAPER) {
			return SCISSORS;
		} else if (this == SCISSORS) {
			return ROCK;
		}
		return null;
	}

	public Signs drawsTo() {
		return this;
	}

	public Signs computeRequiredSign(String you) {
		String hasToLose = "X";
		String hasToDraw = "Y";
		String hasToWin = "Z";

		if (you.equals(hasToLose)) {
			return this.winsOver();
		} else if (you.equals(hasToDraw)) {
			return this.drawsTo();
		} else if (you.equals(hasToWin)) {
			return this.losesTo();
		}

		return null;

	}

	public static Signs of(String opponent) {
		if (opponent.equals("A")) {
			return Signs.ROCK;
		} else if (opponent.equals("B")) {
			return Signs.PAPER;
		} else if (opponent.equals("C")) {
			return Signs.SCISSORS;
		}
		return null;
	}

	Signs(String opponent) {
		this.opponent = opponent;
	}
}
