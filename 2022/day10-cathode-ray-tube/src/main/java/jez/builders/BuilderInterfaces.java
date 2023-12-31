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
		AddXOperationBuilder withCurrentX(int currentX);
	}

}
