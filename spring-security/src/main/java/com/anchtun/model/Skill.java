package com.anchtun.model;

import com.anchtun.enums.SkillLevel;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Skill {

	private String name;
	private SkillLevel level;

}
