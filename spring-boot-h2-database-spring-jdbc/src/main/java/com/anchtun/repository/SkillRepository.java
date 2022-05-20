package com.anchtun.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.anchtun.model.Skill;

@Repository
public class SkillRepository {

	private final JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	SkillRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Skill> findSkills() {
		String sql = "select name, level from skill";
		// we can use BeanPropertyRowMapper provided by Spring when the column names in the table 
		// and field names inside POJO/Bean are matching
		var rowMapper = BeanPropertyRowMapper.newInstance(Skill.class);
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	public List<Skill> findSkillByLevel(String level) {
		String sql = "select name, level from skill where level = :level";
		SqlParameterSource namedParameters = new MapSqlParameterSource("level", level);
		var rowMapper = BeanPropertyRowMapper.newInstance(Skill.class);
		return namedParameterJdbcTemplate.query(sql, namedParameters, rowMapper);
	}
	
}
