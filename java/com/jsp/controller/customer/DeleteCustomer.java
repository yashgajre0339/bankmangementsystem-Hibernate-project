package com.jsp.controller.customer;

import com.jsp.service.CustomerService;

public class DeleteCustomer {
public static void main(String[] args) {
		
		
		int id = 2;
		
		CustomerService customerService = new CustomerService();
		customerService.deleteCustomer(id);
	}


}
