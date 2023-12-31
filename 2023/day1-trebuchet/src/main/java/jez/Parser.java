package jez;

public class Parser
{
	public static String parse(String value)
	{
		String newString = "";
		for (int index = 0; index < value.length(); index++)
		{
			if (value.charAt(index) >= '1' && value.charAt(index) <= '9')
			{
				newString += value.charAt(index);
			} else if (
				index + 3 <= value.length() &&
						value.substring(index, index + 3)
								.equals("one")
			)
			{
				newString += 1;
			} else if (
				index + 3 <= value.length() &&
						value.substring(index, index + 3)
								.equals("two")
			)
			{
				newString += 2;
			} else if (
				index + 5 <= value.length() &&
						value.substring(index, index + 5)
								.equals("three")
			)
			{
				newString += 3;
			} else if (
				index + 4 <= value.length() &&
						value.substring(index, index + 4)
								.equals("four")
			)
			{
				newString += 4;
			} else if (
				index + 4 <= value.length() &&
						value.substring(index, index + 4)
								.equals("five")
			)
			{
				newString += 5;
			} else if (
				index + 3 <= value.length() &&
						value.substring(index, index + 3)
								.equals("six")
			)
			{
				newString += 6;
			} else if (
				index + 5 <= value.length() &&
						value.substring(index, index + 5)
								.equals("seven")
			)
			{
				newString += 7;
			} else if (
				index + 5 <= value.length() &&
						value.substring(index, index + 5)
								.equals("eight")
			)
			{
				newString += 8;
			} else if (
				index + 4 <= value.length() &&
						value.substring(index, index + 4)
								.equals("nine")
			)
			{
				newString += 9;
			}
		}
		return newString;
	}
}
