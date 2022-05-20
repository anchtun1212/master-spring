package com.anchtun.controller;

import static com.anchtun.enums.SkillLevel.EXPERT;
import static com.anchtun.enums.SkillLevel.INTERMEDIATE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anchtun.constants.Constants;
import com.anchtun.enums.SkillLevel;
import com.anchtun.model.Skill;
import com.anchtun.service.SkillService;

@Controller
public class SkillController {
	
	@Autowired
	private SkillService skillService;

	@GetMapping("/skill")
	public String skillPage(Model model) {
		List<Skill> skills = Arrays.asList(
				new Skill("Java", EXPERT),
				new Skill("Spring", EXPERT),
				new Skill("SQL", EXPERT),
				new Skill("PHP", INTERMEDIATE), 
				new Skill("C", INTERMEDIATE),
				new Skill("Python", INTERMEDIATE));
		
		SkillLevel[] skillLevels = SkillLevel.values();
		for (SkillLevel level : skillLevels) {
			model.addAttribute(level.toString(),
					skills.stream().filter(skill -> skill.getLevel().equals(level)).collect(Collectors.toList()));

		}
		return "skill.html";
	}

	/**
	 * 
	 * use @RequestParam annotation
	 */
	@GetMapping("/skill-req-param")
	public String skillPage(@RequestParam(required = false) String skill, @RequestParam(required = false) String level,
			Model model) {
		// model.addAttribute("skill", skill);
		// we will test only level attribute
		model.addAttribute("level", level);
		List<Skill> skills = Arrays.asList(
				new Skill("Java", EXPERT),
				new Skill("Spring", EXPERT),
				new Skill("SQL", EXPERT),
				new Skill("PHP", INTERMEDIATE), 
				new Skill("C", INTERMEDIATE),
				new Skill("Python", INTERMEDIATE));
		
		SkillLevel[] skillLevels = SkillLevel.values();
		for (SkillLevel lev : skillLevels) {
			model.addAttribute(lev.toString(),
					skills.stream().filter(skil -> skil.getLevel().equals(lev)).collect(Collectors.toList()));

		}
		return "skillrequestparam.html";
	}

	/**
	 * 
	 * use @PathVariable annotation
	 */
	@GetMapping("/skill/{display}")
	public String skillPage(@PathVariable String display, Model model) {
		model.addAttribute("display", display);
		List<Skill> skills = Arrays.asList(
				new Skill("Java", EXPERT),
				new Skill("Spring", EXPERT),
				new Skill("SQL", EXPERT),
				new Skill("PHP", INTERMEDIATE), 
				new Skill("C", INTERMEDIATE),
				new Skill("Python", INTERMEDIATE));
		
		SkillLevel[] skillLevels = SkillLevel.values();
		for (SkillLevel lev : skillLevels) {
			model.addAttribute(lev.toString(),
					skills.stream().filter(skil -> skil.getLevel().equals(lev)).collect(Collectors.toList()));

		}
		return "skillpathvariable.html";
	}
	
	@RequestMapping("/skillH2")
	public ModelAndView skillH2(Model model) {
		List<Skill> skillsH2List = skillService.findSkills();
		ModelAndView modelAndView = new ModelAndView("skillsH2.html");
		modelAndView.addObject("skillsH2List", skillsH2List);
		return modelAndView;
	}
	
	@RequestMapping("/skillByLevelH2")
	public ModelAndView skillByLevelH2(Model model) {
		List<Skill> skillsH2ByLevel = skillService.skillByLevelH2(Constants.INTERMEDIATE);
		ModelAndView modelAndView = new ModelAndView("skillsH2ByLevel.html");
		modelAndView.addObject("skillsH2ByLevel", skillsH2ByLevel);
		return modelAndView;
	}
}
