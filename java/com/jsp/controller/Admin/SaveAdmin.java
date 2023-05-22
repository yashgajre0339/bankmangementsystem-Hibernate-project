package com.jsp.controller.Admin;

import com.jsp.bank.dto.Admin;
import com.jsp.service.AdminService;

public class SaveAdmin {
public static void main(String[] args) {
		
		
		String name = "ronaldo";
		
		String email = "ronaldo@gmail.com";
		
		String password = "777";
		
		Admin admin = new Admin();
		admin.setName(name);
		admin.setEmail(email);
		admin.setPassword(password);
		
		AdminService adminService = new AdminService();
		adminService.saveAdmin(admin);
	}
}
