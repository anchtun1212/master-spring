package com.anchtun.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.anchtun.model.Course;

// change the spring data rest path name
@RepositoryRestResource(path = "courses")
@Repository
// must change extends CrudRepository to extends PagingAndSortingRepository in order to use pagination and sorting
// you can extends JpaRepository that extends PagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T>
public interface CourseRepository extends PagingAndSortingRepository<Course, Integer> {

	List<Course> findAll();
	
	// static sorting
	// by default order by ASC
	List<Course> findByOrderByName();
	
}
