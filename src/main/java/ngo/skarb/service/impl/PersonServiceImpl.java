package ngo.skarb.service.impl;

import ngo.skarb.lessons.Person;
import ngo.skarb.service.PersonService;

public class PersonServiceImpl implements PersonService {

	@Override
	public Person create(Person person) {
		return person;
	}
}
