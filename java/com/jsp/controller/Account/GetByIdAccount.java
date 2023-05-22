package com.jsp.controller.Account;



import com.jsp.service.CustomerService;

public class GetByIdAccount {
	
		public static void main(String[] args) {
			
			int customer_id= 1;
			
			CustomerService customerService = new CustomerService();
			customerService.getAccountById(customer_id);
		}

}
