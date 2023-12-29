package jez;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Tree
{
	private final int height;
	private final int row;
	private final int column;
	private Forest forest;

	public int getHeight()
	{
		return height;
	}

	public Tree(int height, int row, int column)
	{
		this.height = height;
		this.row = row;
		this.column = column;
	}

	public void setForest(Forest newForest)
	{
		this.forest = newForest;
	}

	public int getRow()
	{
		return row;
	}

	public int getColumn()
	{
		return column;
	}

	public Forest getForest()
	{
		return forest;
	}

	public List<Tree> getTreesAbove()
	{
		return forest.column(this.getColumn())
				.stream()
				.filter(tree -> tree.getRow() < this.getRow())
				.toList();
	}

	public List<Tree> getTreesBelow()
	{
		return forest.column(this.getColumn())
				.stream()
				.filter(tree -> tree.getRow() > this.getRow())
				.toList();
	}

	public List<Tree> getTreesToTheRight()
	{
		return forest.row(this.getRow())
				.stream()
				.filter(tree -> tree.getColumn() > this.getColumn())
				.toList();
	}

	public List<Tree> getTreesToTheLeft()
	{
		return forest.row(this.getRow())
				.stream()
				.filter(tree -> tree.getColumn() < this.getColumn())
				.toList();
	}

	public boolean isHidden()
	{
		boolean topCovered = getTreesAbove().stream()
				.anyMatch(tree -> tree.getHeight() >= this.getHeight());
		boolean botCovered = getTreesBelow().stream()
				.anyMatch(tree -> tree.getHeight() >= this.getHeight());
		boolean leftCovered = getTreesToTheLeft().stream()
				.anyMatch(tree -> tree.getHeight() >= this.getHeight());
		boolean rightCovered = getTreesToTheRight().stream()
				.anyMatch(tree -> tree.getHeight() >= this.getHeight());

		return topCovered &&
				botCovered &&
				leftCovered &&
				rightCovered;
	}

	protected int viewingDistanceTop()
	{
		if (getTreesAbove().isEmpty())
		{
			return 0;
		}
		AtomicBoolean addOne = new AtomicBoolean(false);
		int count = (int) getTreesAbove().stream()
				.sorted((tree1, tree2) -> {
					return Integer.compare(tree2.getRow(), tree1.getRow());
				})
				.takeWhile(tree -> {
					if (tree.getHeight() < this.getHeight())
					{
						return true;
					}
					addOne.set(true);
					return false;
				})
				.count();
		if (addOne.get())
		{
			count++;
		}
		return count;
	}

	protected int viewingDistanceBot()
	{
		if (getTreesBelow().isEmpty())
		{
			return 0;
		}
		AtomicBoolean addOne = new AtomicBoolean(false);
		int count = (int) getTreesBelow().stream()
				.sorted((tree1, tree2) -> {
					return Integer.compare(tree1.getRow(), tree2.getRow());
				})
				.takeWhile(tree -> {
					if (tree.getHeight() < this.getHeight())
					{
						return true;
					}
					addOne.set(true);
					return false;
				})
				.count();
		if (addOne.get())
		{
			count++;
		}
		return count;
	}

	protected int viewingDistanceLeft()
	{
		if (getTreesToTheLeft().isEmpty())
		{
			return 0;
		}
		AtomicBoolean addOne = new AtomicBoolean(false);
		int count = (int) getTreesToTheLeft().stream()
				.sorted((tree1, tree2) -> {
					return Integer.compare(tree2.getColumn(), tree1.getColumn());
				})
				.takeWhile(tree -> {
					if (tree.getHeight() < this.getHeight())
					{
						return true;
					}
					addOne.set(true);
					return false;
				})
				.count();
		if (addOne.get())
		{
			count++;
		}
		return count;
	}

	protected int viewingDistanceRight()
	{
		if (getTreesToTheRight().isEmpty())
		{
			return 0;
		}
		AtomicBoolean addOne = new AtomicBoolean(false);
		int count = (int) getTreesToTheRight().stream()
				.sorted((tree1, tree2) -> {
					return Integer.compare(tree1.getColumn(), tree2.getColumn());
				})
				.takeWhile(tree -> {
					if (tree.getHeight() < this.getHeight())
					{
						return true;
					}
					addOne.set(true);
					return false;
				})
				.count();
		if (addOne.get())
		{
			count++;
		}
		return count;
	}

	public int scenicScore()
	{
		return viewingDistanceTop() * viewingDistanceBot() * viewingDistanceLeft()
				* viewingDistanceRight();
	}
}
