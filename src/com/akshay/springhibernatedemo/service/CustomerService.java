package com.akshay.springhibernatedemo.service;

import java.util.List;

import com.akshay.springhibernatedemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
}
