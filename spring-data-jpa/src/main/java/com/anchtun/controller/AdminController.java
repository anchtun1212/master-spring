package com.anchtun.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpSession;
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
import com.anchtun.model.Course;
import com.anchtun.model.Person;
import com.anchtun.service.ClassroomService;
import com.anchtun.service.CourseService;
import com.anchtun.service.PersonService;

import lombok.extern.slf4j.Slf4j;

// this controller all admin actions
@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private ClassroomService classroomService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private CourseService courseService;
	
	// classroom operations
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
			personService.savePersonDefault(person);
		}
		classroomService.deleteClassroom(id);
		return ("redirect:/admin/classrooms");
	}
	
	// student operations
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
		String errorMessage = null;
		// to be used for back button 
		Classroom classroom = (Classroom) session.getAttribute("classroom");
		model.addAttribute("classroom", classroom);
		if (errors.hasErrors()) {
			log.error("Error occured during save student: " + errors.toString());
			return ("addstudent.html");
		}
		Person student = personService.findPersonByEmail(person.getEmail());
		if (Objects.isNull(student)) {
			errorMessage = "Please enter exists email!!!";
			model.addAttribute("errorMessage", errorMessage);
			log.error("Please recheck the email: " + errors.toString());
			return ("addstudent.html");
		}
		
		student.setClassroom(classroom);
		personService.savePersonDefault(student);
		
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
			personService.savePersonDefault(student);
		}
		
		classroom.getPersons().remove(student);
		classroomService.saveClassroom(classroom);
		
		model.addAttribute("classroom", classroom);
		
		return ("redirect:/admin/students?id=" + classroom.getClassroomId());
	}
	
	// courses operations
	@GetMapping("/courses")
	public String goToCourses(Model model) {
		List<Course> courses = courseService.findAll();
		model.addAttribute("courses", courses);
		return "courses.html";
	}
	
	@GetMapping("/addcourse")
	public String goToAddCourse(Model model) {
		model.addAttribute("course", new Course());
		return "addcourse.html";
	}
	
	@PostMapping("/savecourse")
	public String saveCourse(@Valid @ModelAttribute("course") Course course, Errors errors) {
		if (errors.hasErrors()) {
			log.error("Error occured during save course: " + errors.toString());
			return ("addcourse.html");
		}

		courseService.saveCourse(course);

		return ("redirect:/admin/courses");
	}
	
	@RequestMapping("/deletecourse")
	public String deleteCourse(@RequestParam int id) {
		courseService.deleteCourse(id);
		return ("redirect:/admin/courses");
	}

	@RequestMapping("/viewstudents")
	public String viewStudents(@RequestParam int id, Model model, HttpSession session) {
		Optional<Course> course = courseService.findById(id);
		model.addAttribute("course", course.get());
		session.setAttribute("course", course.get());
		Set<Person> students = course.get().getPersons();
		model.addAttribute("students", students);
		return "viewstudents.html";
	}
	
	@GetMapping("/addstudenttocourse")
	public String goToAddStudentToCourse(Model model, HttpSession session) {
		// to be used for back buton 
		Course course = (Course) session.getAttribute("course");
		model.addAttribute("course", course);
		model.addAttribute("student", new Person());
		session.setAttribute("course", course);
		return "addstudenttocourse.html";
	}
	
	@PostMapping("/savestudentcourse")
	// no need to valid email matches when search
	public String saveStudentCourse(@ModelAttribute("student") Person person, Errors errors, HttpSession session, Model model) {
		String errorMessage = null;
		// to be used for back button 
		Course course = (Course) session.getAttribute("course");
		model.addAttribute("course", course);
		if (errors.hasErrors()) {
			log.error("Error occured during save student: " + errors.toString());
			return ("addstudent.html");
		}
		Person student = personService.findPersonByEmail(person.getEmail());
		if (Objects.isNull(student)) {
			errorMessage = "Please enter exists email!!!";
			model.addAttribute("errorMessage", errorMessage);
			log.error("Please recheck the email: " + errors.toString());
			return ("addstudenttocourse.html");
		}
		
		student.getCourses().add(course);
		personService.savePersonDefault(student);
		
		course.getPersons().add(student);
		courseService.saveCourse(course);
		
		// set last courses
		session.setAttribute("course", course);
		
		return ("redirect:/admin/viewstudents?id=" + course.getCourseId());
	}
	
	@RequestMapping("/deleteStudentCourse")
	public String deleteStudentCourse(@RequestParam int id, HttpSession session, Model model) {
		// to be used for back button 
		Course course = (Course) session.getAttribute("course");
		
		Person student = personService.findPersonById(id);
		if (Objects.nonNull(student)) {
			student.getCourses().remove(course);
			course.getPersons().remove(student);
			// use savePersonDefault instead of savePerson to not hash the password of the users again
			personService.savePersonDefault(student);
			model.addAttribute("course", course);
		}
		
		return ("redirect:/admin/viewstudents?id=" + course.getCourseId());
	}

}
