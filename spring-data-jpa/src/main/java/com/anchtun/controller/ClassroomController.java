package com.anchtun.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anchtun.model.Classroom;
import com.anchtun.model.Person;
import com.anchtun.service.ClassroomService;
import com.anchtun.service.PersonService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("admin")
public class ClassroomController {
	
	@Autowired
	private ClassroomService classroomService;
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/classrooms")
	public String goToClassroom(Model model) {
		List<Classroom> classrooms = classroomService.findAll();
		model.addAttribute("classrooms", classrooms);
		return "classrooms.html";
	}
	
	@GetMapping("/addclassroom")
	public String goToAddClassroom(Model model) {
		model.addAttribute("classroom", new Classroom());
		return "addclassroom.html";
	}
	
	@PostMapping("/saveclassroom")
	public String saveClassroom(@Valid @ModelAttribute("classroom") Classroom classroom, Errors errors) {
		if (errors.hasErrors()) {
			log.error("Error occured during save classroom: " + errors.toString());
			return ("addclassroom.html");
		}

		classroomService.saveClassroom(classroom);

		return ("redirect:/admin/classrooms");
	}
	
	@RequestMapping("/deleteclassroom")
	public String delete(@RequestParam int id) {
		Optional<Classroom> classroom = classroomService.findById(id);
		for (Person person : classroom.get().getPersons()) {
			person.setClassroom(null);
			personService.savePerson(person);
		}
		classroomService.deleteClassroom(id);
		return ("redirect:/admin/classrooms");
	}

}
