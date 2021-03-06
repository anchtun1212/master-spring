package com.anchtun.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.anchtun.model.Course;
import com.anchtun.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	public void saveCourse(Course course) {
		courseRepository.save(course);
	}

	public Optional<Course> findById(int id) {
		return courseRepository.findById(id);
	}

	public void deleteCourse(int id) {
		courseRepository.deleteById(id);
	}

	// static sorting
	public List<Course> findByNameOrderByAsc() {
		return courseRepository.findByOrderByName();
	}

	// dynamic sorting
	public List<Course> findAllDynamicSorting() {
		return (List<Course>) courseRepository.findAll(Sort.by("name").ascending());
	}
}
