package com.anchtun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anchtun.constants.Constants;
import com.anchtun.model.Skill;
import com.anchtun.service.SkillService;

@Controller
public class SkillController {
	
	@Autowired
	private SkillService skillService;

	@RequestMapping("/skillDB")
	public ModelAndView skillH2(Model model) {
		List<Skill> skillsH2List = skillService.findSkills();
		ModelAndView modelAndView = new ModelAndView("skillsDB.html");
		modelAndView.addObject("skillsH2List", skillsH2List);
		return modelAndView;
	}
	
	@RequestMapping("/skillByLevelDB")
	public ModelAndView skillByLevelH2(Model model) {
		List<Skill> skillsH2ByLevel = skillService.skillByLevelH2(Constants.INTERMEDIATE);
		ModelAndView modelAndView = new ModelAndView("skillsDBByLevel.html");
		modelAndView.addObject("skillsH2ByLevel", skillsH2ByLevel);
		return modelAndView;
	}
}
