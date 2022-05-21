package com.anchtun.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.anchtun.model.Person;
import com.anchtun.repository.PersonRepository;

@Service
public class PersonService {

	private final PersonRepository personRepository;

	// no need to add @Autowired because there is only one constructor
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public boolean savePerson(Person person) {
		boolean isSaved = false;
		Person result = personRepository.save(person);
		if (Objects.nonNull(result) && result.getPersonId() > 0) {
			isSaved = true;
		}
		return isSaved;
	}

}
