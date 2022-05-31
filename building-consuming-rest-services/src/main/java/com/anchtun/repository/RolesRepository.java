package com.anchtun.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.anchtun.model.Roles;

// if you don't want to expose this repository
@RepositoryRestResource(exported = false)
@Repository
public interface RolesRepository extends CrudRepository<Roles, Integer> {

	Roles findByRoleName(String roleUser);

}
