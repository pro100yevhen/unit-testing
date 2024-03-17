package ngo.skarb.matchers;

import ngo.skarb.lessons.Person;

import org.mockito.ArgumentMatcher;

public class PersonAgeMatcher implements ArgumentMatcher<Person> {

	@Override
	public boolean matches(Person person) {
		return person.getAge() > 18;
	}
}
