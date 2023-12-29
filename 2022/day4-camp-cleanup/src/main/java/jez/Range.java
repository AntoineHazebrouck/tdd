package jez;

public class Range {
	private final Integer start;
	private final Integer end;

	public Range(Integer start, Integer end) {
		this.start = start;
		this.end = end;
	}

	public Integer start() {
		return start;
	}

	public Integer end() {
		return end;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this)
			return true;
		if (!(other instanceof Range))
			return false;
		Range otherRange = (Range) other;
		return this.start == otherRange.start && this.end == otherRange.end;
	}

	public Boolean contains(Range contained) {
		return this.start <= contained.start && this.end >= contained.end;
	}

	public Boolean contains(Integer number) {
		return number >= start && number <= end;
	}

	public Boolean isContainedBy(Range container) {
		return container.contains(this);
	}

	public Boolean overlaps(Range range) {
		Integer minOfBoth = Integer.min(this.start, range.start);
		Integer maxOfBoth = Integer.max(this.end, range.end);
		for (int index = minOfBoth; index <= maxOfBoth; index++) {
			if (this.contains(index) && range.contains(index)) {
				return true;
			}
		}
		return false;
	}
}
