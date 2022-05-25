package com.anchtun.service;

import static com.anchtun.constants.Constants.ROLE_ADMIN;

import java.util.Objects;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.anchtun.model.Person;
import com.anchtun.model.Roles;
import com.anchtun.repository.PersonRepository;
import com.anchtun.repository.RolesRepository;

@Service
public class PersonService {

	private final PersonRepository personRepository;
	private final RolesRepository rolesRepository;
	// inject the interface name so if we need to change the PasswordEncoder class in the future we need just
	// to change in ProjectSecurityConfig.java not in PersonService.java
	private final PasswordEncoder passwordEncoder;

	// no need to add @Autowired because there is only one constructor
	public PersonService(PersonRepository personRepository, RolesRepository rolesRepository, PasswordEncoder passwordEncoder) {
		this.personRepository = personRepository;
		this.rolesRepository = rolesRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public boolean savePerson(Person person) {
		boolean isSaved = false;
		Roles role = rolesRepository.findByRoleName(ROLE_ADMIN);
		person.setRoles(role);
		person.setPassword(passwordEncoder.encode(person.getPassword()));
		Person result = personRepository.save(person);
		if (Objects.nonNull(result) && result.getPersonId() > 0) {
			isSaved = true;
		}
		return isSaved;
	}
	
	public void savePersonDefault(Person person) {
		personRepository.save(person);
	}
	
	public Person findPersonByEmail(String email) {
		return personRepository.readByEmail(email);
	}
	
}
