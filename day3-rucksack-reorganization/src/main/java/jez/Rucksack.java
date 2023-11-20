package jez;

public class Rucksack {
	private String input;

	public Rucksack(String input) {
		this.input = input;
	}

	public static Rucksack of(String input) {
		return new Rucksack(input);
	}

	public int length() {
		return input.length();
	}

	public Rucksack getLeftCompartment() {
		int middle = this.length() / 2;
		return new Rucksack(input.substring(0, middle));
	}

	public Rucksack getRightCompartment() {
		int middle = this.length() / 2;
		return new Rucksack(input.substring(middle));
	}

	@Override
	public String toString() {
		return input;
	}

	public Character sharesAnyOf(Rucksack otherCompartment) {
		Character sharedChar = null;
		for (char otherCharacter : otherCompartment.toString().toCharArray()) {
			for (char character : this.toString().toCharArray()) {
				if (otherCharacter == character) {
					sharedChar = character;
				}
			}
		}
		return sharedChar;
	}

	public Rucksack shares(Rucksack otherCompartment) {
		String sharedCharacters = "";
		for (char otherCharacter : otherCompartment.toString().toCharArray()) {
			for (char character : this.toString().toCharArray()) {
				if (otherCharacter == character) {
					sharedCharacters += character;
				}
			}
		}
		return Rucksack.of(sharedCharacters);
	}
}
