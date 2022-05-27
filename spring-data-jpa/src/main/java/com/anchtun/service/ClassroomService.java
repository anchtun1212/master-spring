package com.anchtun.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anchtun.model.Classroom;
import com.anchtun.repository.ClassroomRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClassroomService {

	private final ClassroomRepository classroomRepository;

	public Classroom saveClassroom(Classroom classroom) {
		return classroomRepository.save(classroom);
	}

	public List<Classroom> findAll() {
		return classroomRepository.findAll();
	}

	public void deleteClassroom(Integer id) {
		classroomRepository.deleteById(id);
	}
	
	public Optional<Classroom> findById(Integer id) {
		return classroomRepository.findById(id);
	}

}
