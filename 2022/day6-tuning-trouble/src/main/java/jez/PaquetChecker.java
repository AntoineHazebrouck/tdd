package jez;

public class PaquetChecker
{
	public Boolean check(String paquet)
	{
		for (Character character : paquet.toCharArray())
		{
			if (paquet.chars().filter(char2 -> char2 == character).count() > 1)
			{
				return false;
			}
		}
		return true;
	}
}
