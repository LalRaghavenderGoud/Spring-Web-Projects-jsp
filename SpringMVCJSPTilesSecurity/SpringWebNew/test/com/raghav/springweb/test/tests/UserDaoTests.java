package com.raghav.springweb.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.raghav.springweb.dao.OfferDao;
import com.raghav.springweb.dao.User;
import com.raghav.springweb.dao.UsersDao;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:com/raghav/springweb/configxml/dao-context.xml",
		"classpath:com/raghav/springweb/configxml/security-context.xml",
		"classpath:com/raghav/springweb/test/config/testDataSource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {

	@Autowired
	private UsersDao userDao;

	@Autowired
	private DataSource dataSource;

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("delete from offers");
		jdbc.execute("delete from users");
	}

	@Test
	public void testCreateUser() {

		User user = new User("Raghav", "test123", "test@gmail.com", true, "ROLE_USER", "Raghav");
		assertTrue("User Created return True", userDao.create(user));

		List<User> users = userDao.getAllUsers();
		assertEquals("No Of user are 1", 1, users.size());

		assertEquals("User Created Should Match with Retrived", user, users.get(0));

		assertTrue("User should exists", userDao.exists(user.getUsername()));

	}

}
