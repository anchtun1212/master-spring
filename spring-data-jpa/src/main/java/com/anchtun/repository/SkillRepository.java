package com.anchtun.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anchtun.enums.SkillLevel;
import com.anchtun.model.Skill;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {

	List<Skill> findAll();
	List<Skill> findByLevel(SkillLevel level);
	
}
