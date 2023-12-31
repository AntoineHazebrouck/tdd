package jez.builders;

public final class BuilderInterfaces
{
	private BuilderInterfaces()
	{}

	public interface AddXOperationStepV
	{
		OperationBuilderStepCurrentCycle withV(int v);
	}


	public interface OperationBuilderStepCurrentCycle
	{
		OperationBuilderStepCurrentX withCurrentCycle(int currentCycle);
	}


	public interface OperationBuilderStepCurrentX
	{
		OperationBuilder withCurrentX(int currentX);
	}

}
