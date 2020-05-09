package com.raghav.springweb.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("usersrDao")
public class UsersDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	@Transactional
	public boolean create(User user) {

		// BeanPropertySqlParameterSource param = new
		// BeanPropertySqlParameterSource(user);
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("username", user.getUsername());
		param.addValue("password", passwordEncoder.encode(user.getPassword()));
		param.addValue("email", user.getEmail());
		param.addValue("enabled", user.isEnabled());
		param.addValue("authority", user.getAuthority());
		param.addValue("name", user.getName());

		return jdbc.update(
				"insert into users(username,password,email,enabled,name,authority) values(:username,:password,:email,:enabled,:name,:authority)",
				param) == 1;
	}

	public boolean exists(String username) {
		return jdbc.queryForObject("select count(1) from users where username=:username",
				new MapSqlParameterSource("username", username), Integer.class) > 0;

	}

	public List<User> getAllUsers() {

		return jdbc.query("select * from users", BeanPropertyRowMapper.newInstance(User.class));
	}

}
