package jez;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RockPaperScissorsTest {
	private final Game game = new Game();
	@Test
	void score_for_a_line() {
		assertEquals(3 + 1, game.getScore(Signs.ROCK, Signs.ROCK));
		assertEquals(6 + 2, game.getScore(Signs.ROCK, Signs.PAPER));
		assertEquals(0 + 3, game.getScore(Signs.ROCK, Signs.SCISSORS));

		assertEquals(0 + 1, game.getScore(Signs.PAPER, Signs.ROCK));
		assertEquals(3 + 2, game.getScore(Signs.PAPER, Signs.PAPER));
		assertEquals(6 + 3, game.getScore(Signs.PAPER, Signs.SCISSORS));

		assertEquals(6 + 1, game.getScore(Signs.SCISSORS, Signs.ROCK));
		assertEquals(0 + 2, game.getScore(Signs.SCISSORS, Signs.PAPER));
		assertEquals(3 + 3, game.getScore(Signs.SCISSORS, Signs.SCISSORS));
	}

	@Test
	void get_losing_sign() {
		assertEquals(Signs.SCISSORS, Signs.ROCK.winsOver());
		assertEquals(Signs.ROCK, Signs.PAPER.winsOver());
		assertEquals(Signs.PAPER, Signs.SCISSORS.winsOver());
	}

	@Test
	void get_drawing_sign() {
		assertEquals(Signs.ROCK, Signs.ROCK.drawsTo());
		assertEquals(Signs.PAPER, Signs.PAPER.drawsTo());
		assertEquals(Signs.SCISSORS, Signs.SCISSORS.drawsTo());
	}

	@Test
	void get_winning_sign() {
		assertEquals(Signs.PAPER, Signs.ROCK.losesTo());
		assertEquals(Signs.SCISSORS, Signs.PAPER.losesTo());
		assertEquals(Signs.ROCK, Signs.SCISSORS.losesTo());
	}
}
