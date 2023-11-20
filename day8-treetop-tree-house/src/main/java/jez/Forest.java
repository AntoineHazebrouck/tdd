package jez;

import java.util.List;

public class Forest
{
	private final List<Tree> trees;

	private Forest(List<Tree> trees)
	{
		this.trees = trees;
	}

	public static Forest link(List<Tree> trees)
	{
		Forest newForest = new Forest(trees);
		for (Tree tree : trees)
		{
			tree.setForest(newForest);
		}
		return newForest;
	}

	public List<Tree> getTrees()
	{
		return trees;
	}

	public List<Tree> row(int row)
	{
		return trees.stream()
				.filter(tree -> tree.getRow() == row)
				.toList();
	}

	public List<Tree> column(int column)
	{
		return trees.stream()
				.filter(tree -> tree.getColumn() == column)
				.toList();
	}

	public List<Tree> getVisibleTrees()
	{
		return trees.stream()
				.filter(tree -> !tree.isHidden())
				.toList();
	}
}
