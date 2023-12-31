package jez.entities;

public class NoOperation extends Operation
{
	public static final int nbCycles = 1;

	public NoOperation(int currentCycle, int currentX)
	{
		super(currentCycle, currentX);
	}

	@Override
	public String toString()
	{
		return "NoOperation [currentCycle=" + super.currentCycle + ", currentX=" + super.currentX
				+ "]";
	}
}
