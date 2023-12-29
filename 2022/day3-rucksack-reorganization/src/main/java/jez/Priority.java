package jez;

public class Priority {
	private static final String priotitiesChart = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static int of(char letter) {
		return priotitiesChart.indexOf(letter) + 1;
	}
}
