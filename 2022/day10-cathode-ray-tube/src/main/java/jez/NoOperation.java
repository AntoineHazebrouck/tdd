package jez;

public class NoOperation extends Operation
{
	public static final int nbCycles = 1;

	public static class NoOperationBuilder
	{
		private int currentCycle;
		private int currentX;

		public NoOperationBuilder withCurrentCycle(int currentCycle)
		{
			this.currentCycle = currentCycle;
			return this;
		}

		public NoOperationBuilder withCurrentX(int currentX)
		{
			this.currentX = currentX;
			return this;
		}

		public NoOperation build()
		{
			return new NoOperation(currentCycle, currentX);
		}
	}

	protected NoOperation(int currentCycle, int currentX)
	{
		super(currentCycle, currentX);
	}
}
