package jez.entities;

public class AddXOperation extends Operation
{
	public static final int nbCycles = 2;

	private final int v;


	public AddXOperation(int currentCycle, int currentX, int v)
	{
		super(currentCycle, currentX);
		this.v = v;
	}

	public int getV()
	{
		return v;
	}
}
