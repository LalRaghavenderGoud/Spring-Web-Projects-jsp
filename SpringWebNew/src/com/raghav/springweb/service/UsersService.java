package com.raghav.springweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghav.springweb.dao.User;
import com.raghav.springweb.dao.UsersDao;

@Service("usersService")
public class UsersService {

	private UsersDao usersDao;

	@Autowired
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public void create(User user) {
		usersDao.createOffer(user);

	}

	public boolean exists(String username) {
		return usersDao.exists(username);
	}

}
