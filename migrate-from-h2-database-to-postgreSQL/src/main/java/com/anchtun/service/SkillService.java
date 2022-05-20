package com.anchtun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anchtun.model.Skill;
import com.anchtun.repository.SkillRepository;

@Service
public class SkillService {
	
	@Autowired
	private SkillRepository skillRepository;

	public List<Skill> findSkills() {
		return skillRepository.findSkills();
	}

	public List<Skill> skillByLevelH2(String level) {
		return skillRepository.findSkillByLevel(level);
	}

}
