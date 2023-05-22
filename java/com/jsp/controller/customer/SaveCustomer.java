package com.jsp.controller.customer;

import com.jsp.bank.dto.Customer;
import com.jsp.service.CustomerService;

public class SaveCustomer {
public static void main(String[] args) {
		
				String name = "yash";
				String address = "panvel";
				String status = "unaproved";
		
		String adhar_no = "0987654321";
		
		Customer customer = new Customer();
		customer.setName(name);
		customer.setAddress(address);
		customer.setStatus(status);
		customer.setAadhar_no(adhar_no);
		
		CustomerService customerService = new CustomerService();
		customerService.saveCustomer(customer);
	}

}
