package com.anchtun.security;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
//used for all non prod profile
// for all non prod profile allow user to login without checking the username and password
// and give the user the ADMIN role
@Profile("!prod")
public class AnchtunNonProdUsernamePasswordAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		return new UsernamePasswordAuthenticationToken(username, null, getGrantedAuthorities());
	}

	private List<GrantedAuthority> getGrantedAuthorities() {
		// give the user the ADMIN role
		List<GrantedAuthority> grantedAuthorities = List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return grantedAuthorities;

	}

	// for all non prod profile allow user to login without checking the username and password
	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
