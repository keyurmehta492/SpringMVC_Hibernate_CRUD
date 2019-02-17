package com.luv2code.springdemo.service;

import java.util.List;
import com.luv2code.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomers(Customer theCustomer);

	public Customer getCustomers(int theId);

	public void deleteCustomers(int theId);
}
