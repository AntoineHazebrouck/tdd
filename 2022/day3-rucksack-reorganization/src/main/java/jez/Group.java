package jez;

public class Group {
	private Rucksack firstRucksack;
	private Rucksack secondRucksack;
	private Rucksack thirdRucksack;

	public Group(String group) {
		firstRucksack = Rucksack.of(group.split("\r\n")[0]);
		secondRucksack = Rucksack.of(group.split("\r\n")[1]);
		thirdRucksack = Rucksack.of(group.split("\r\n")[2]);
	}

	public Group(String rucksack1, String rucksack2, String rucksack3) {
		firstRucksack = Rucksack.of(rucksack1);
		secondRucksack = Rucksack.of(rucksack2);
		thirdRucksack = Rucksack.of(rucksack3);
	}

	/**
	 * @return the firstRucksack
	 */
	public Rucksack getFirstRucksack() {
		return firstRucksack;
	}

	/**
	 * @return the secondRucksack
	 */
	public Rucksack getSecondRucksack() {
		return secondRucksack;
	}

	/**
	 * @return the thirdRucksack
	 */
	public Rucksack getThirdRucksack() {
		return thirdRucksack;
	}

	public char sharedByAllThree() {
		return firstRucksack.shares(secondRucksack).shares(thirdRucksack).toString().charAt(0);
	}


}
