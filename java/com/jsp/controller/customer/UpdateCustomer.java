package com.jsp.controller.customer;

import com.jsp.bank.dto.Customer;
import com.jsp.service.CustomerService;

public class UpdateCustomer {

public static void main(String[] args) {
		
		Customer customer = new Customer();
		customer.setId(1);

		customer.setAadhar_no("1234 5678 9101 1213");
		
		CustomerService customerService = new CustomerService();
		customerService.updateCustomer(customer);
	}
}
