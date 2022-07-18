package com.revature.services;

import java.util.List;

import com.revature.daos.RoleDAO;
import com.revature.daos.RoleHibernate;
import com.revature.daos.UserDAO;
import com.revature.daos.UserHibernate;
import com.revature.exceptions.UserNotFoundException;
import com.revature.exceptions.UserNotUpdatedException;
import com.revature.models.Role;
import com.revature.models.User;

public class UserService {
	
	private UserDAO ud = new UserHibernate();
	
	public List<User> getUsers() {
		List<User> users = ud.getUsers();
		return users;
	}
	
	public boolean updatetUser(User u) throws UserNotUpdatedException {
		boolean checkUpdate =ud.updateUser(u);
		if (checkUpdate == false) {
			throw new UserNotUpdatedException();
		}
		return checkUpdate;
	}
	
	public User getUserById(int id) throws UserNotFoundException {
		User u = ud.getUserById(id);
		if (u == null) {
			throw new UserNotFoundException();
		}
		return u;
	}	
	
	public List<User> getByRole(String role_name) {
		RoleDAO rh = new RoleHibernate();
		Role r = rh.getByName(role_name);
 		List<User> users = ud.getByRole(r);
		return users;
	}


}
