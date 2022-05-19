package com.anchtun.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.anchtun.model.Contact;
import com.anchtun.rowmappers.ContactRowMapper;

/**
 * @Repository: stereotype annotation is used to add a bean of this class type
 *              to the Spring context and indicate that given bean is used to
 *              perform DB related operations
 */
@Repository
public class ContactRepository {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	ContactRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveContactMsg(Contact contact) {
		String sql = "insert into contact_msg(name,mobile_num,email,subject,status,created_at,created_by) "
				+ "values (?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, contact.getFullName2(), contact.getMobile2(), contact.getEmail2(),
				contact.getSubject2(), contact.getStatus(), contact.getCreatedAt(), contact.getCreatedBy());
	}

	public List<Contact> findMsgsByStatus(String status) {
		String sql = "select * from contact_msg where status = ?";
		return jdbcTemplate.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, status);
			}
		}, new ContactRowMapper());
	}

}
