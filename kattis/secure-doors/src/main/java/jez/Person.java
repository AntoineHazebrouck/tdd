package jez;

import java.util.Optional;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person {
	@EqualsAndHashCode.Include
	private final String name;
	private final Location current;

	
	public Optional<Person> enter()
	{
		if (current == Location.IN) return Optional.empty();
		return Optional.of(new Person(name, Location.IN));
	}

	public Optional<Person> exit()
	{
		if (current == Location.OUT) return Optional.empty();
		return Optional.of(new Person(name, Location.OUT));
	}

	public boolean isIn()
	{
		return current == Location.IN;
	}

	public boolean isOut()
	{
		return current == Location.OUT;
	}

}
