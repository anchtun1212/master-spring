package com.anchtun.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anchtun.model.Classroom;

@Repository
public interface ClassroomRepository extends CrudRepository<Classroom, Integer> {

	List<Classroom> findAll();
}
