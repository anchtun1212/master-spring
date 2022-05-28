package com.anchtun.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.anchtun.model.Contact;

public class ContactRowMapper implements RowMapper<Contact> {

	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact contact = new Contact();
		contact.setContactId(rs.getInt("contact_id"));
		contact.setName(rs.getString("name"));
		contact.setEmail(rs.getString("email"));
		contact.setMobile(rs.getString("mobile_num"));
		contact.setSubject(rs.getString("subject"));
		contact.setStatus(rs.getString("status"));
		contact.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
		contact.setCreatedBy(rs.getString("created_by"));

		if (null != rs.getTimestamp("updated_at")) {
			contact.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
		}
		if (null != rs.getString("updated_by")) {
			contact.setUpdatedBy(rs.getString("updated_by"));
		}

		return contact;
	}

}
