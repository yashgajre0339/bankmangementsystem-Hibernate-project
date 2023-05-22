package com.jsp.controller.BankManger;

import com.jsp.bank.dto.BankManager;
import com.jsp.service.BankMangerService;

public class ApproveCustomer {

	public static void main(String[] args) {
			
			
			int id = 1;
			
			String email = "abc@gmail.com";
			
			String password = "0339";
			
			BankManager bankmanager = new BankManager();
			bankmanager.setId(id);
			bankmanager.setEmail(email);
			bankmanager.setPassword(password);
			
			BankMangerService bankmanagerService = new BankMangerService();
			bankmanagerService.approveManager(bankmanager);
		}

	
}
