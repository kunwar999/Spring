package com.example.service;

import java.util.List;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import com.example.repository.CustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository repository = new CustomerRepositoryImpl();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.service.CustomerService#findAll()
	 */
	@Override
	public List<Customer> findAll() {
		return this.repository.findAll();
	}
}
