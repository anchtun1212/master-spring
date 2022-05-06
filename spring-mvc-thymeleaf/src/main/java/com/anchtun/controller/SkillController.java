package com.anchtun.controller;

import static com.anchtun.enums.SkillLevel.EXPERT;
import static com.anchtun.enums.SkillLevel.INTERMEDIATE;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.anchtun.model.Skill;

@Controller
public class SkillController {

	@GetMapping("/skill")
	public String skillPage(Model model) {
		List<Skill> skills = Arrays.asList(
				new Skill("Java", EXPERT), 
				new Skill("Spring", EXPERT),
				new Skill("SQL", EXPERT), 
				new Skill("PHP", INTERMEDIATE),
				new Skill("C", INTERMEDIATE));
		model.addAttribute("skills", skills);
		return "skill.html";
	}
}
