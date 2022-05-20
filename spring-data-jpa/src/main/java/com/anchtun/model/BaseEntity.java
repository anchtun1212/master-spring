package com.anchtun.model;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
// indicates to spring data jpa that all the entities that extends this class please treat those fields as columns
@MappedSuperclass
public class BaseEntity {
	
	private LocalDateTime createdAt;
	private String createdBy;
	private LocalDateTime updatedAt;
	private String updatedBy;

}
