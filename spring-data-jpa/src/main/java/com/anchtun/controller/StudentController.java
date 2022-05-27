package com.anchtun.controller;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpSession;

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
public class StudentController {

	@Autowired
	private ClassroomService classroomService;

	@Autowired
	private PersonService personService;

	@RequestMapping("/students")
	public String displayStudents(@RequestParam int id, Model model, HttpSession session) {
		Optional<Classroom> classroom = classroomService.findById(id);
		model.addAttribute("classroom", classroom.get());
		session.setAttribute("classroom", classroom.get());
		Set<Person> students = classroom.get().getPersons();
		model.addAttribute("students", students);
		return "students.html";
	}
	
	@GetMapping("/addstudent")
	public String goToAddStudent(Model model, HttpSession session) {
		// to be used for back buton 
		Classroom classroom = (Classroom) session.getAttribute("classroom");
		model.addAttribute("classroom", classroom);
		model.addAttribute("student", new Person());
		return "addstudent.html";
	}
	
	@PostMapping("/savestudent")
	// no need to valid email matches when search
	public String saveStudent(@ModelAttribute("student") Person person, Errors errors, HttpSession session, Model model) {
		// to be used for back button 
		Classroom classroom = (Classroom) session.getAttribute("classroom");
		model.addAttribute("classroom", classroom);
		if (errors.hasErrors()) {
			log.error("Error occured during save student: " + errors.toString());
			return ("addstudent.html");
		}
		Person student = personService.findPersonByEmail(person.getEmail());
		if (Objects.isNull(student)) {
			log.error("Please recheck the email: " + errors.toString());
			return ("addstudent.html");
		}
		person = student;
		
		student.setClassroom(classroom);
		personService.savePerson(student);
		
		classroom.getPersons().add(student);
		classroomService.saveClassroom(classroom);
		
		return ("redirect:/admin/students?id=" + classroom.getClassroomId());
	}
	
	@RequestMapping("/deletestudent")
	public String delete(@RequestParam int id, HttpSession session, Model model) {
		// to be used for back button 
		Classroom classroom = (Classroom) session.getAttribute("classroom");
		
		Person student = personService.findPersonById(id);
		if (Objects.nonNull(student)) {
			student.setClassroom(null);
			personService.savePerson(student);
		}
		
		classroom.getPersons().remove(student);
		classroomService.saveClassroom(classroom);
		
		model.addAttribute("classroom", classroom);
		
		return ("redirect:/admin/students?id=" + classroom.getClassroomId());
	}

}
