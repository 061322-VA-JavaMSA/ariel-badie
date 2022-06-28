package com.revature.services;

import com.revature.daos.CustomerDAO;
import com.revature.daos.CustomerPostgres;
import com.revature.exceptions.LoginException;
import com.revature.models.Customer;

public class AuthService {

	private CustomerDAO ud = new CustomerPostgres();
	
	public Customer login(String username, String password) throws LoginException {
		// if username/password passed are null, throws an exception
		if(username == null || password == null) {
			throw new LoginException();
		}
		
		Customer u = ud.retrieveCustomerByUsername(username);
		// if no user of that name has been retrieved/if pass don't match, throw an exception
		if(u == null || !u.getPassword().equals(password)) {
			throw new LoginException();
		}
		return u;
	}
}