package com.jsp.controller.Account;

import com.jsp.bank.dto.Account;
import com.jsp.service.CustomerService;

public class SaveAccount {
public static void main(String[] args) {
	int customer_id = 1;
	
	double balance = 1000;
	
	 if(balance > 999) {
		Account account = new Account();
		account.setBalance(balance);
		
		CustomerService customerService = new CustomerService();
		customerService.saveAccount(customer_id, account);
	}
	else {
		System.out.println("Initial amount should be minimum ₹1000");
	}
}
}




