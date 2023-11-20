package jez;

public class Game {
	private static final int ROCK_SCORE = 1;
	private static final int PAPER_SCORE = 2;
	private static final int SCISSORS_SCORE = 3;

	private static final int WIN_SCORE = 6;
	private static final int DRAW_SCORE = 3;
	private static final int LOST_SCORE = 0;

	public int getScore(Signs opponent, Signs you) {
		int score = 0;
		if (you.equals(Signs.ROCK)) {
			score += ROCK_SCORE;
			if (opponent.equals(Signs.ROCK)) {
				score += DRAW_SCORE;
			} else if (opponent.equals(Signs.PAPER)) {
				score += LOST_SCORE;
			} else if (opponent.equals(Signs.SCISSORS)) {
				score += WIN_SCORE;
			}
		} else if (you.equals(Signs.PAPER)) {
			score += PAPER_SCORE;
			if (opponent.equals(Signs.ROCK)) {
				score += WIN_SCORE;
			} else if (opponent.equals(Signs.PAPER)) {
				score += DRAW_SCORE;
			} else if (opponent.equals(Signs.SCISSORS)) {
				score += LOST_SCORE;
			}
		} else if (you.equals(Signs.SCISSORS)) {
			score += SCISSORS_SCORE;
			if (opponent.equals(Signs.ROCK)) {
				score += LOST_SCORE;
			} else if (opponent.equals(Signs.PAPER)) {
				score += WIN_SCORE;
			} else if (opponent.equals(Signs.SCISSORS)) {
				score += DRAW_SCORE;
			}
		}
		return score;
	}

}
