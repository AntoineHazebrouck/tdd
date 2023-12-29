package jez;

public class AssignmentPair {
	private final Range left;
	private final Range right;

	public AssignmentPair(Range left, Range right) {
		this.left = left;
		this.right = right;
	}

	public Range getLeft() {
		return left;
	}

	public Range getRight() {
		return right;
	}

}
