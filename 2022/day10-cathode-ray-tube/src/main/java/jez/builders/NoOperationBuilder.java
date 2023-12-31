package jez.builders;

import jez.builders.BuilderInterfaces.NoOperationOperationBuilderStepCurrentCycle;
import jez.builders.BuilderInterfaces.NoOperationOperationBuilderStepCurrentX;
import jez.entities.NoOperation;

public class NoOperationBuilder extends OperationBuilder
		implements NoOperationOperationBuilderStepCurrentCycle,
		NoOperationOperationBuilderStepCurrentX
{
	private int currentCycle;
	private int currentX;

	@Override
	public OperationBuilder withCurrentX(int currentX)
	{
		this.currentX = currentX;
		return this;
	}

	@Override
	public NoOperationOperationBuilderStepCurrentX withCurrentCycle(int currentCycle)
	{
		this.currentCycle = currentCycle;
		return this;
	}

	@Override
	public NoOperation build()
	{
		return new NoOperation(currentCycle, currentX);
	}

}
