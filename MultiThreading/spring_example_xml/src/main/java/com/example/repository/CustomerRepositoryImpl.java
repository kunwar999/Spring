package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Customer;

public class CustomerRepositoryImpl implements CustomerRepository {

	/* (non-Javadoc)
	 * @see com.example.repository.CustomerRepository#findAll()
	 */
	@Override
	public List<Customer> findAll() {
		List<Customer> customers = new ArrayList<Customer>();
		Customer customer = new Customer();
		customer.setFirstName("Ankit");
		customer.setLastName("Singh");
		customers.add(customer);
		return customers;
	}
}
