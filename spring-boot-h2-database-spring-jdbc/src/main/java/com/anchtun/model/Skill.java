package com.anchtun.model;

import com.anchtun.enums.SkillLevel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Skill extends BaseEntity {

	private String name;
	private SkillLevel level;

}
