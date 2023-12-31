package jez.entities;

import jez.builders.AddXOperationBuilder;
import jez.builders.BuilderInterfaces.OperationBuilderStepCurrentCycle;
import jez.builders.BuilderInterfaces.AddXOperationStepV;
import jez.builders.NoOperationBuilder;

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

	public Operation next(OperationBuilderStepCurrentCycle addXOperationBuilderStepCurrentCycle)
	{
		return addXOperationBuilderStepCurrentCycle
				.withCurrentCycle(currentCycle + AddXOperation.nbCycles)
				.withCurrentX(currentX)
				.build();
	}
}
