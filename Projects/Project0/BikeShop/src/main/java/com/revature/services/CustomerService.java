package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.CustomerDAO;
import com.revature.daos.CustomerPostgres;
import com.revature.models.Customer;

public class CustomerService {

	private CustomerDAO ud = new CustomerPostgres();
	private static Logger log = LogManager.getLogger(CustomerService.class);
	
	public List<Customer> getCustomer(){
		return ud.retrieveCustomer();
	}
	
	public Customer createCustomer(Customer u) {
		// logic to validate u
		// if ok
//		u = ud.createUser(u);
		Customer cust = ud.createCustomer(u);
		log.info("Customer: " + cust + " was created.");
		return cust;
	}
}