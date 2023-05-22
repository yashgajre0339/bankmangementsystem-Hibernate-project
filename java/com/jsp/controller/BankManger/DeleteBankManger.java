package com.jsp.controller.BankManger;

import com.jsp.service.BankMangerService;

public class DeleteBankManger {
	
		public static void main(String[] args) {
			int id = 2;
			
			BankMangerService bankmanagerService = new BankMangerService();
			bankmanagerService.deleteBankManager(id);
		}

}
