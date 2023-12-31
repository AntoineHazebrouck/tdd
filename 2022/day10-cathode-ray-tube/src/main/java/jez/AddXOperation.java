package jez;

public class AddXOperation extends Operation
{
	public static final int nbCycles = 2;

	private final int v;

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

	public static class AddXOperationBuilder implements AddXOperationStepV,
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

		public AddXOperation build()
		{
			return new AddXOperation(currentCycle, currentX + v, v);
		}
	}

	protected AddXOperation(int currentCycle, int currentX, int v)
	{
		super(currentCycle, currentX);
		this.v = v;
	}

	public int getV()
	{
		return v;
	}
}
