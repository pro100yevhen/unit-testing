package ngo.skarb.lessons;

import ngo.skarb.matchers.PersonAgeMatcher;
import ngo.skarb.service.PersonService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class PersonAgeTest {

	@Mock
	private PersonService personService;

	@Test
	public void shouldCheckIfPersonAgeIsValid_whenValidAgeIsPassedToPersonServiceCreateMethod() {

		final int validAge = 20;
		final String name = "John";

		Person person = new Person(name, validAge);
		when(personService.create(person)).thenReturn(person);

		personService.create(person);

		verify(personService).create(argThat(new PersonAgeMatcher()));
	}

}
