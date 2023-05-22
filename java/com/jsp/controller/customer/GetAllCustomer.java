package com.jsp.controller.customer;

import com.jsp.service.CustomerService;

public class GetAllCustomer {
	
		public static void main(String[] args) {
			
			CustomerService customerService = new CustomerService();
			customerService.getAllCustomer();
		}

	}

