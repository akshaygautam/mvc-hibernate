package com.akshay.springhibernatedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.akshay.springhibernatedemo.dao.CustomerDAO;
import com.akshay.springhibernatedemo.entity.Customer;

@Service
@Transactional
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private	CustomerDAO customerDAO;
	
	@Override
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}

	@Override
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
	}

}
