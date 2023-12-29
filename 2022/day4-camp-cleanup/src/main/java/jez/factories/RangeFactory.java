package jez.factories;

import jez.Range;

public class RangeFactory {

	public Range getRange(String range) {
		final String[] splitRange = range.split("-");
		final Integer start = Integer.parseInt(splitRange[0]);
		final Integer end = Integer.parseInt(splitRange[1]);

		return new Range(start, end);
	}

}
