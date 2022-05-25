package com.anchtun.security;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.anchtun.model.Person;
import com.anchtun.model.Roles;
import com.anchtun.repository.PersonRepository;

/**
 * Since we are using spring boot we don't need to inject this class in ProjectSecurityConfig class
 * also we don't need to override: protected void configure(AuthenticationManagerBuilder auth)
 * and spring boot will do all his magic
 */

@Component
public class AnchtunUsernamePasswordAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		// we can use: read, find, get, query
		Person person = personRepository.readByEmail(username);
		boolean personDataMatch = (Objects.nonNull(person) && Objects.nonNull(person.getPassword())
				// matches: will convert first the password to hash value
				// then compare it with the value inside the DB
				&& passwordEncoder.matches(password, person.getPassword()));
		if (personDataMatch) {
			// I will pass: person.getName() instead of email so  the username will be shown in the UI
			// will set the password to null for more secure
			return new UsernamePasswordAuthenticationToken(person.getEmail(), null, getGrantedAuthorities(person.getRoles()));
		} else {
			throw new BadCredentialsException("Bad credentials!");
		}
	}

	private List<GrantedAuthority> getGrantedAuthorities(Roles roles) {
		// spring security always use the roles with the prefix: ROLE_
		List<GrantedAuthority> grantedAuthorities = List.of(new SimpleGrantedAuthority("ROLE_" + roles.getRoleName()));
		return grantedAuthorities;

	}

	// UsernamePasswordAuthenticationToken has two fields:
	// Object principal: will store the username
	// Object credentials: will store the password
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
