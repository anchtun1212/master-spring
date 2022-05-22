package com.anchtun.repository;

import org.springframework.data.repository.CrudRepository;

import com.anchtun.model.Roles;

public interface RolesRepository extends CrudRepository<Roles, Integer> {

	Roles findByRoleName(String roleUser);

}
