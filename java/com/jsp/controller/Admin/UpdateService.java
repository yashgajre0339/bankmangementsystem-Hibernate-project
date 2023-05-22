package com.jsp.controller.Admin;

import com.jsp.bank.dto.Admin;
import com.jsp.service.AdminService;

public class UpdateService {
public static void main(String[] args) {
		
		Admin admin = new Admin();
		admin.setId(2);
		admin.setName("Benzama");
		admin.setPassword("999");
		
		AdminService adminService = new AdminService();
		adminService.updateAdmin(admin);
	}
}
