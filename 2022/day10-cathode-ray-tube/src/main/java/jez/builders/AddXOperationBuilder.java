package jez.builders;

import jez.builders.BuilderInterfaces.OperationBuilderStepCurrentCycle;
import jez.builders.BuilderInterfaces.OperationBuilderStepCurrentX;
import jez.builders.BuilderInterfaces.AddXOperationStepV;
import jez.entities.AddXOperation;
import jez.entities.Operation;

public class AddXOperationBuilder extends OperationBuilder implements AddXOperationStepV,
		OperationBuilderStepCurrentCycle, OperationBuilderStepCurrentX
{
	private int currentCycle;
	private int currentX;
	private int v;

	@Override
	public AddXOperationBuilder withCurrentX(int currentX)
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
	public OperationBuilderStepCurrentCycle withV(int v)
	{
		this.v = v;
		return this;
	}

	@Override
	public Operation build()
	{
		return new AddXOperation(currentCycle, currentX + v, v);
	}
}
