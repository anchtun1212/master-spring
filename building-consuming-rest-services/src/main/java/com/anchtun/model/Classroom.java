package com.anchtun.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

// we remove @Data and we used @Getter and @Setter instead because of bug on lombok
// because @Data annotation generates toString and equalsAndHashCode methods
// that cause problems when using oneToMany and manyToMany mapping
//@Data
@Getter
@Setter
@Entity
public class Classroom extends BaseEntity {

	@Id
	@Column(name = "classroom_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int classroomId;
	
	@NotBlank(message = "Name must not be blank")
	@Size(min = 3, message = "Name must have at least 3 characters")
	private String name;
	
	// will keep the default fetch = LAZY: to not affect the performance
	// if we want to load a class that have huge number of students
	// mappedBy always in the entity that owns the bidirectional relationship
	// cascade = CascadeType.PERSIST: only PERSIST, suppose you delete class you cannot delete students
	// because the student can go to other classes, same for update...
	@OneToMany(mappedBy = "classroom", cascade = CascadeType.PERSIST, targetEntity = Person.class)
	private Set<Person> persons;
}
