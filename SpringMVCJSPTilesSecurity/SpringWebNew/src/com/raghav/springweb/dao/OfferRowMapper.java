package com.raghav.springweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OfferRowMapper implements RowMapper<Offers> {

	@Override
	public Offers mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user = new User();

		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setEnabled(rs.getBoolean("enabled"));
		user.setEmail(rs.getString("email"));
		user.setAuthority(rs.getString("authority"));
		user.setName(rs.getString("name"));

		Offers offer = new Offers();

		offer.setId(rs.getInt("id"));
		offer.setText(rs.getString("text"));
		offer.setUser(user);

		return offer;
	}

}
