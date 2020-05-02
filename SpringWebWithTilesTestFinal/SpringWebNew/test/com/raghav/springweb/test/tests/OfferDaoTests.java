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
import com.raghav.springweb.dao.Offers;
import com.raghav.springweb.dao.User;
import com.raghav.springweb.dao.UsersDao;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:com/raghav/springweb/configxml/dao-context.xml",
		"classpath:com/raghav/springweb/configxml/security-context.xml",
		"classpath:com/raghav/springweb/test/config/testDataSource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferDaoTests {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private OfferDao offersDao;
	
	@Autowired
	private UsersDao userDao;
	
	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("delete from offers");
		jdbc.execute("delete from users");
	}
	
	@Test
	public void testOffers() {
		User user = new User("Raghav", "test123", "test@gmail.com", true, "ROLE_USER", "Raghav");
		assertTrue("User Created return True", userDao.create(user));
		
		Offers offer = new Offers("Famous Cricketer",user);
	
		assertTrue("Offer Created Should Return True",offersDao.createOffer(offer));
		
		List<Offers> offers = offersDao.getOffers();
		
		assertEquals("No of ofeers equal to 1", 1, offers.size());
		offer = offers.get(0);
		offer.setText("test update text");
		assertTrue("Offer update return true", offersDao.updateOffer(offer));
		
		Offers updated = offersDao.getOffers(offer.getId());
		assertEquals("Updated should match with retrieved",offer,updated);
		
		Offers offer2 = new Offers("this is a test offer",user);	
		assertTrue("Offer shiuld return true",offersDao.createOffer(offer2));
		
		List<Offers> userOffers = offersDao.getOffers(user.getUsername());
		assertEquals("Nof of offers should be 2",2,userOffers.size());
		
		offersDao.deleteOffer(offer.getId());
		List<Offers> empty = offersDao.getOffers();
		assertEquals("List of offers should be zero", 1, empty.size());
		
		
		//assertEquals("Retrivewed user should match with created user", offer, offers.get(0));
	}
}
