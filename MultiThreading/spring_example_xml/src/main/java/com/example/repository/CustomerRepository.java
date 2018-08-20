package com.example.repository;

import java.util.List;

import com.example.model.Customer;

public interface CustomerRepository {

	List<Customer> findAll();

}