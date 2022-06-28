package com.revature.daos;

import java.util.List;

import com.revature.models.Customer;

public interface CustomerDAO {
	Customer createCustomer(Customer u);
	Customer retrieveCustomerById(int id);
	List<Customer> retrieveCustomer();
	Customer retrieveCustomerByUsername(String username);
	boolean updateCustomer(Customer u);
	boolean deleteCustomerById(int id);
}