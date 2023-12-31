package jez.builders;

import jez.builders.BuilderInterfaces.OperationBuilderStepCurrentCycle;
import jez.builders.BuilderInterfaces.OperationBuilderStepCurrentX;
import jez.entities.NoOperation;

public class NoOperationBuilder extends OperationBuilder
		implements OperationBuilderStepCurrentCycle, OperationBuilderStepCurrentX
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
	public OperationBuilderStepCurrentX withCurrentCycle(int currentCycle)
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
