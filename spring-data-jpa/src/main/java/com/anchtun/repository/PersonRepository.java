package com.anchtun.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anchtun.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
