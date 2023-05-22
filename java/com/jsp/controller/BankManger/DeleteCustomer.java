package com.jsp.controller.BankManger;

import com.jsp.service.BankMangerService;

public class DeleteCustomer {
public static void main(String[] args) {
		
		
		int bankmanager_id = 2;
		System.out.println("Enter Customer id");
		int customer_id = 1;
		
		BankMangerService managerService = new BankMangerService();
		managerService.deleteCustomer(bankmanager_id, customer_id);
		
		
	}

}
