package jez.entities;

import jez.builders.AddXOperationBuilder;
import jez.builders.BuilderInterfaces.AddXOperationBuilderStepCurrentCycle;
import jez.builders.BuilderInterfaces.AddXOperationStepV;
import jez.builders.BuilderInterfaces.NoOperationOperationBuilderStepCurrentCycle;
import jez.builders.NoOperationBuilder;

public abstract class Operation
{
	protected final int currentCycle;
	protected final int currentX;

	protected Operation(int currentCycle, int currentX)
	{
		this.currentCycle = currentCycle;
		this.currentX = currentX;
	}

	public static NoOperationOperationBuilderStepCurrentCycle noOperation()
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

	public Operation next(
			NoOperationOperationBuilderStepCurrentCycle noOperationOperationBuilderStepCurrentCycle)
	{
		return noOperationOperationBuilderStepCurrentCycle
				.withCurrentCycle(currentCycle + NoOperation.nbCycles)
				.withCurrentX(currentX)
				.build();
	}

	@Override
	public String toString()
	{
		return "Operation [currentCycle=" + currentCycle + ", currentX=" + currentX + "]";
	}

}
