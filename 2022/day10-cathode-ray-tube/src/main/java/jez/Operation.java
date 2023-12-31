package jez;

import jez.AddXOperation.AddXOperationBuilder;
import jez.AddXOperation.AddXOperationBuilderStepCurrentCycle;
import jez.AddXOperation.AddXOperationStepV;
import jez.NoOperation.NoOperationBuilder;

public abstract class Operation
{
	private final int currentCycle;
	private final int currentX;

	protected Operation(int currentCycle, int currentX)
	{
		this.currentCycle = currentCycle;
		this.currentX = currentX;
	}

	public static NoOperationBuilder noOperation()
	{
		return new NoOperationBuilder();
	}

	public static AddXOperationStepV addX()
	{
		return new AddXOperationBuilder();
	}

	public int getCurrentCycle()
	{
		return currentCycle;
	}

	public int getCurrentX()
	{
		return currentX;
	}

	public Operation next(AddXOperationBuilderStepCurrentCycle addXOperationBuilderStepCurrentCycle)
	{
		return addXOperationBuilderStepCurrentCycle
				.withCurrentCycle(currentCycle + AddXOperation.nbCycles)
				.withCurrentX(currentX)
				.build();
	}

	// public Operation next(AddXOperationBuilder addX)
	// {
	// return addX
	// .withCurrentCycle(currentCycle + AddXOperation.nbCycles)
	// .withCurrentX(currentX)
	// // withV is already set in the test
	// .build();
	// }
}
