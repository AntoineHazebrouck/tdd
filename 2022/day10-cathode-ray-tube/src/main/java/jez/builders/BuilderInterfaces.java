package jez.builders;

public final class BuilderInterfaces
{
	private BuilderInterfaces()
	{}

	public interface AddXOperationStepV
	{
		AddXOperationBuilderStepCurrentCycle withV(int v);
	}


	public interface AddXOperationBuilderStepCurrentCycle
	{
		AddXOperationBuilderStepCurrentX withCurrentCycle(int currentCycle);
	}


	public interface AddXOperationBuilderStepCurrentX
	{
		OperationBuilder withCurrentX(int currentX);
	}

	public interface NoOperationOperationBuilderStepCurrentCycle
	{
		NoOperationOperationBuilderStepCurrentX withCurrentCycle(int currentCycle);
	}


	public interface NoOperationOperationBuilderStepCurrentX
	{
		OperationBuilder withCurrentX(int currentX);
	}
}
