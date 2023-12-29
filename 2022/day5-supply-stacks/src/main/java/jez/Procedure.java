package jez;

public class Procedure {
	private Integer from;
	private Integer to;
	private Integer nbCratesToMove;

	public Procedure(Integer nbCratesToMove, Integer from, Integer to) {
		this.from = from;
		this.to = to;
		this.nbCratesToMove = nbCratesToMove;
	}

	public Integer from() {
		return from;
	}

	public Integer to() {
		return to;
	}

	public Integer getNbCratesToMove() {
		return nbCratesToMove;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		result = prime * result + ((nbCratesToMove == null) ? 0 : nbCratesToMove.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Procedure other = (Procedure) obj;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		if (nbCratesToMove == null) {
			if (other.nbCratesToMove != null)
				return false;
		} else if (!nbCratesToMove.equals(other.nbCratesToMove))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Procedure [from=" + from + ", to=" + to + ", nbCratesToMove=" + nbCratesToMove
				+ "]";
	}

	
}
