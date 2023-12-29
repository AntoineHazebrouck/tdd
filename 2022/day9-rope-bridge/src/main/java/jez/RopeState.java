package jez;

public class RopeState {
	private final Head head;
	private final Tail tail;
	private RopeState previousState;

	public RopeState(Head head, Tail tail) {
		this.head = head;
		this.tail = tail;
		this.previousState = null;
	}

	public RopeState next(Direction whereTo) {
		this.previousState = this;
		// si Tail en diagonale actuellement, placer Tail à la place du Head precedent
		RopeState ropeState = null;
		int currentRow = this.getHead().getRow();
		int nextRow = 0;
		int currentColumn = this.getHead().getColumn();
		int nextColumn = 0;

		switch (whereTo) {
			case UP:
				currentRow = this.getHead().getRow();
				nextRow = currentRow - 1;

				if (Math.abs(nextRow - tail.getRow()) > 1) {
					ropeState = new RopeState(
							new Head(this.getHead().getRow() - 1,
									this.getHead().getColumn()),
							new Tail(this.getTail().getRow(),
									this.getTail().getColumn()));
				} else {
					ropeState = new RopeState(
							new Head(this.getHead().getRow() - 1,
									this.getHead().getColumn()),
							new Tail(this.getTail().getRow(),
									this.getTail().getColumn()));
				}
				break;
			case DOWN:
				// si Tail sur la meme column actuellement ET tail au dessus de 1, deplacer tail
				currentRow = this.getHead().getRow();
				nextRow = currentRow + 1;

				if (Math.abs(nextRow - tail.getRow()) > 1) {
					ropeState = new RopeState(
							new Head(nextRow,
									this.getHead().getColumn()),
							new Tail(this.getTail()
									.getRow() + 1,
									this.getTail().getColumn()));
				} else {
					ropeState = new RopeState(
							new Head(nextRow,
									this.getHead().getColumn()),
							new Tail(this.getTail()
									.getRow(),
									this.getTail().getColumn()));
				}

				break;
			case LEFT:
				if (Math.abs(nextColumn - tail.getColumn()) > 1) {
					ropeState = new RopeState(
							new Head(this.getHead().getRow(),
									this.getHead().getColumn() - 1),
							new Tail(this.getTail().getRow(),
									this.getTail().getColumn() - 1));
				} else {
					ropeState = new RopeState(
							new Head(this.getHead().getRow(),
									this.getHead().getColumn() - 1),
							new Tail(this.getTail().getRow(),
									this.getTail().getColumn()));
				}

				break;
			case RIGHT:
				if (Math.abs(nextColumn - tail.getColumn()) > 1) {
					ropeState = new RopeState(
							new Head(this.getHead().getRow(),
									this.getHead().getColumn() + 1),
							new Tail(this.getTail().getRow(),
									this.getTail().getColumn() + 1));
				} else {
					ropeState = new RopeState(
							new Head(this.getHead().getRow(),
									this.getHead().getColumn() + 1),
							new Tail(this.getTail().getRow(),
									this.getTail().getColumn()));
				}
				break;

			default:
				break;
		}
		return ropeState;
	}

	public Head getHead() {
		return head;
	}

	public Tail getTail() {
		return tail;
	}
}
