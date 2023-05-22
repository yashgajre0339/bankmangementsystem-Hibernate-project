package com.jsp.controller.BankManger;

import com.jsp.service.BankMangerService;

public class GetByIdBankManger {
public static void main(String[] args) {
		
		
		int id = 1;
		
		BankMangerService bankmanagerService = new BankMangerService();
		bankmanagerService.getBankManagerById(id);
	}
}
