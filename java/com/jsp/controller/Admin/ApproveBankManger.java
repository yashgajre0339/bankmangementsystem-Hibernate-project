package com.jsp.controller.Admin;

import com.jsp.service.AdminService;

public class ApproveBankManger {
public static void main(String[] args) {
		
		int id = 1;
		
		String email = "shrish@gmail.com";
			String password = "123456";
		
		AdminService adminService = new AdminService();
		adminService.approveAdmin(id, email, password);
		
	}

}
