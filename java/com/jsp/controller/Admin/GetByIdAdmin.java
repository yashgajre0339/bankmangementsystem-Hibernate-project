package com.jsp.controller.Admin;

import com.jsp.service.AdminService;

public class GetByIdAdmin {
public static void main(String[] args) {
		
		
		int id = 1;
		
		AdminService adminService = new AdminService();
		adminService.getAdminById(id);
	}

}
