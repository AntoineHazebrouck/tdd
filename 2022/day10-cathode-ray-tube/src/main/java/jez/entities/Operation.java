package jez.entities;

import jez.builders.AddXOperationBuilder;
import jez.builders.BuilderInterfaces.AddXOperationBuilderStepCurrentCycle;
import jez.builders.BuilderInterfaces.AddXOperationStepV;
import jez.entities.NoOperation.NoOperationBuilder;

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
}
