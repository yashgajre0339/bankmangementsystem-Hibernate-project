package com.jsp.controller.Admin;

import com.jsp.service.AdminService;

public class DeleteAdmin {
public static void main(String[] args) {
		
		
		int id = 3;
		
		AdminService adminService = new AdminService();
		adminService.deleteAdmin(id);
	}

}
