package com.jsp.controller.BankManger;

import com.jsp.bank.dto.BankManager;
import com.jsp.service.BankMangerService;

public class SaveBankManger {
public static void main(String[] args) {
		
		
		String name = "anirudaha";
		
		String email = "xyz@gmail.com";
		
		String password = "1234";
		
		String status = "approved";
		
		BankManager bankmanager = new BankManager();
		bankmanager.setName(name);
		bankmanager.setEmail(email);
		bankmanager.setPassword(password);
		bankmanager.setStatus(status);
		
		BankMangerService managerService = new BankMangerService();
		managerService.saveBankManager(bankmanager);
	}

}
