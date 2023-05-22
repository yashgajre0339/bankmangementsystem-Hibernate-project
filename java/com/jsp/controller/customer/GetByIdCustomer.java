package com.jsp.controller.customer;

import com.jsp.service.CustomerService;

public class GetByIdCustomer {

public static void main(String[] args) {
		
		
		int id = 1;
		
		CustomerService customerService = new CustomerService();
		customerService.getCustomerById(id);
	}
}
