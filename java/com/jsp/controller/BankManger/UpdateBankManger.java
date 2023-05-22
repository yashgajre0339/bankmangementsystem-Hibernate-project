package com.jsp.controller.BankManger;

import com.jsp.bank.dto.BankManager;
import com.jsp.service.BankMangerService;

public class UpdateBankManger {
public static void main(String[] args) {
		
		BankManager bankmanager = new BankManager();
		bankmanager.setId(2);
		bankmanager.setEmail("Aniruddha@gmail.com");
		
		BankMangerService bankmanagerService = new BankMangerService();
		bankmanagerService.updateBankManager(bankmanager);
	}

}
