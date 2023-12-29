package jez.factories;

import jez.AssignmentPair;
import jez.Range;

public class AssignmentPairFactory {
	private final RangeFactory rangeFactory = new RangeFactory();

	public AssignmentPair getAssignmentPair(String assignmentPair) {
		final String[] splitAssignmentPair = assignmentPair.split(",");

		final Range left = rangeFactory.getRange(splitAssignmentPair[0]);
		final Range right = rangeFactory.getRange(splitAssignmentPair[1]);

		return new AssignmentPair(left, right);
	}

}
