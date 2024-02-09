package jez;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application
{

	public static void main(String[] args)
	{

		String input = """
				entry Abbey
				entry Abbey
				exit Abbey
				entry Tyrone
				exit Mason
				entry Demetra
				exit Latonya
				entry Idella
					""";

		class PersonsHolder
		{
			Set<Person> persons;

			public PersonsHolder(Set<Person> persons)
			{
				this.persons = persons;
			}
		}

		Set<Person> persons = Stream.of(input.split("\n"))
				.map(line -> line.split(" ")[1])
				.map(name -> new Person(name, Location.OUT))
				.collect(Collectors.toSet());

		PersonsHolder personsHolder = new PersonsHolder(persons);

		for (String line : input.split("\n"))
		{
			String name = line.split(" ")[1];
			Person person = personsHolder.persons.stream()
					.filter(personLoop -> personLoop.getName()
							.equals(name))
					.findFirst()
					.get();

			BiFunction<String, String, String> buildMessage = (aName, goingWhere) -> aName + " " + goingWhere;
			BiFunction<String, String, String> buildAnomalyMessage = buildMessage.andThen(myMessage -> myMessage + " (ANOMALY)");
			
			if (line.startsWith("entry"))
			{
				person.enter()
						.ifPresentOrElse(enteredNormally -> {

							personsHolder.persons = replaceMember(enteredNormally, enteredNormally, personsHolder.persons);
							
							System.out.println(buildMessage.apply(name, "entered"));
						}, () -> System.out.println(buildAnomalyMessage.apply(name, "entered")));

			} else
			{
				person.exit()
						.ifPresentOrElse(exitedNormally -> {
							personsHolder.persons = replaceMember(exitedNormally, exitedNormally, personsHolder.persons);
							System.out.println(buildMessage.apply(name, "exited"));
						}, () -> System.out.println(buildAnomalyMessage.apply(name, "exited")));
			}
		}

	}

	private static Set<Person> replaceMember(Person old, Person replacement, Set<Person> persons)
	{
		var copy = new HashSet<>(persons);
		copy.remove(old);
		copy.add(replacement);
		return copy;
	}
}
