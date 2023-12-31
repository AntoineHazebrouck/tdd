package jez.builders;

import jez.builders.BuilderInterfaces.AddXOperationBuilderStepCurrentCycle;
import jez.builders.BuilderInterfaces.AddXOperationBuilderStepCurrentX;
import jez.builders.BuilderInterfaces.AddXOperationStepV;
import jez.entities.AddXOperation;
import jez.entities.Operation;

public class AddXOperationBuilder extends OperationBuilder implements AddXOperationStepV,
		AddXOperationBuilderStepCurrentCycle, AddXOperationBuilderStepCurrentX
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
	public AddXOperationBuilderStepCurrentX withCurrentCycle(int currentCycle)
	{
		this.currentCycle = currentCycle;
		return this;
	}

	@Override
	public AddXOperationBuilderStepCurrentCycle withV(int v)
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
