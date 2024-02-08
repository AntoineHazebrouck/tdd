package jez;

import lombok.val;

public class Application
{

	public static void main(String[] args)
	{
		val nbTeams = 5;

		val initialRanklist = new RankList(nbTeams);

		val step1 = initialRanklist.next(4, 1);
		val step2 = step1.next(3, 1);
		val step3 = step2.next(5, 3);

		System.out.println(step3);
	}
}
