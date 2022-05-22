package com.anchtun.service;

import static com.anchtun.constants.Constants.ROLE_USER;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.anchtun.model.Person;
import com.anchtun.model.Roles;
import com.anchtun.repository.PersonRepository;
import com.anchtun.repository.RolesRepository;

@Service
public class PersonService {

	private final PersonRepository personRepository;
	private final RolesRepository rolesRepository;

	// no need to add @Autowired because there is only one constructor
	public PersonService(PersonRepository personRepository, RolesRepository rolesRepository) {
		this.personRepository = personRepository;
		this.rolesRepository = rolesRepository;
	}

	public boolean savePerson(Person person) {
		boolean isSaved = false;
		Roles role = rolesRepository.findByRoleName(ROLE_USER);
		person.setRoles(role);
		Person result = personRepository.save(person);
		if (Objects.nonNull(result) && result.getPersonId() > 0) {
			isSaved = true;
		}
		return isSaved;
	}

}
