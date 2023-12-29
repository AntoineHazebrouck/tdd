package jez;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ApplicationTest
{
	@Test
	void high_order_test()
	{
		Tree topLeft = new Tree(0, 0, 0);
		Tree topMid = new Tree(2, 0, 1);
		Tree topRight = new Tree(0, 0, 2);

		Tree midLeft = new Tree(3, 1, 0);
		Tree midMid = new Tree(1, 1, 1);
		Tree midRight = new Tree(3, 1, 2);

		Tree botLeft = new Tree(0, 2, 0);
		Tree botMid = new Tree(2, 2, 1);
		Tree botRight = new Tree(0, 2, 2);

		List<Tree> trees = List.of(	topLeft,
									topMid,
									topRight,
									midLeft,
									midMid,
									midRight,
									botLeft,
									botMid,
									botRight);
		Forest forest = Forest.link(trees);

		assertThat(forest.getTrees()
				.size()).isEqualTo(9);

		assertThat(forest.column(0)
				.get(0)
				.getHeight()).isEqualTo(topLeft.getHeight());
		assertThat(forest.row(0)
				.get(0)
				.getHeight()).isEqualTo(topLeft.getHeight());
		assertThat(forest.column(2)
				.get(2)
				.getHeight()).isEqualTo(botRight.getHeight());
		assertThat(forest.row(2)
				.get(2)
				.getHeight()).isEqualTo(botRight.getHeight());

		assertThat(topLeft.getTreesAbove()
				.isEmpty()).isTrue();
		assertThat(topLeft.getTreesBelow()
				.size()).isEqualTo(2);
		assertThat(topLeft.getTreesToTheLeft()
				.isEmpty()).isTrue();
		assertThat(topLeft.getTreesToTheRight()
				.size()).isEqualTo(2);

		assertThat(botRight.getTreesAbove()
				.size()).isEqualTo(2);
		assertThat(botRight.getTreesBelow()
				.isEmpty()).isTrue();
		assertThat(botRight.getTreesToTheLeft()
				.size()).isEqualTo(2);
		assertThat(botRight.getTreesToTheRight()
				.isEmpty()).isTrue();

		assertThat(topLeft.isHidden()).isFalse();
		assertThat(topMid.isHidden()).isFalse();
		assertThat(topRight.isHidden()).isFalse();

		assertThat(midLeft.isHidden()).isFalse();
		assertThat(midMid.isHidden()).isTrue();
		assertThat(midRight.isHidden()).isFalse();

		assertThat(botLeft.isHidden()).isFalse();
		assertThat(botMid.isHidden()).isFalse();
		assertThat(botRight.isHidden()).isFalse();

		assertThat(forest.getVisibleTrees()
				.size()).isEqualTo(8);

		assertThat(topLeft.scenicScore()).isEqualTo(0 * 0 * 1 * 1);
		assertThat(botLeft.scenicScore()).isEqualTo(0 * 0 * 1 * 1);
		assertThat(midMid.scenicScore()).isEqualTo(1 * 1 * 1 * 1);
	}

	@Test
	void viewing_distances()
	{
		Tree row0 = new Tree(1, 0, 0);
		Tree row1 = new Tree(1, 1, 0);
		Tree row2 = new Tree(2, 2, 0);
		Tree row3 = new Tree(3, 3, 0);
		Tree row4 = new Tree(4, 4, 0);
		Tree row5 = new Tree(3, 5, 0);


		List<Tree> trees = List.of(row0, row1, row2, row3, row4, row5);
		Forest forest = Forest.link(trees);

		assertThat(row0.viewingDistanceTop()).isEqualTo(0);
		assertThat(row1.viewingDistanceTop()).isEqualTo(1);
		assertThat(row2.viewingDistanceTop()).isEqualTo(2);
		assertThat(row5.viewingDistanceTop()).isEqualTo(1);
	}
}


