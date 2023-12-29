package jez;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ApplicationTest {
	@Test
	void high_order_test() {
		RopeState state0 = new RopeState(new Head(0, 0), new Tail(0, 0));

		RopeState state1 = state0.next(Direction.DOWN);

		assertThat(state1.getHead()
				.getRow()).isEqualTo(1);
		assertThat(state1.getHead()
				.getColumn()).isEqualTo(0);

		RopeState state2 = state1.next(Direction.DOWN);

		assertThat(state2.getHead()
				.getRow()).isEqualTo(2);
		assertThat(state2.getHead()
				.getColumn()).isEqualTo(0);
		assertThat(state2.getTail()
				.getRow()).isEqualTo(1);
		assertThat(state2.getTail()
				.getColumn()).isEqualTo(0);

		RopeState state3 = state2.next(Direction.RIGHT);

		RopeState state4 = state3.next(Direction.RIGHT);

		assertThat(state4.getHead()
				.getRow()).isEqualTo(2);
		assertThat(state4.getHead()
				.getColumn()).isEqualTo(2);
		assertThat(state4.getTail()
				.getRow()).isEqualTo(2);
		assertThat(state4.getTail()
				.getColumn()).isEqualTo(1);
	}

	@Test
	void diagonal_tail_becomes_former_head() {
		RopeState state0 = new RopeState(new Head(0, 0), new Tail(0, 0));
		RopeState state1 = state0.next(Direction.DOWN);
		RopeState state2 = state1.next(Direction.DOWN);

		RopeState state3 = state2.next(Direction.RIGHT);

		RopeState state4 = state3.next(Direction.RIGHT);

		assertThat(state4.getTail()
				.getRow()).isEqualTo(state3.getHead().getRow());
		assertThat(state4.getTail()
				.getColumn()).isEqualTo(state3.getHead().getColumn());
	}
}
