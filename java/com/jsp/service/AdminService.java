package com.jsp.service;

import com.jsp.bank.dao.AdminDao;
import com.jsp.bank.dto.Admin;

public class AdminService {
	
			
			
			public Admin saveAdmin(Admin admin) {
				AdminDao admindao= new AdminDao();
				
				return admindao.saveAdmin(admin);
			}
			
			public Admin updateAdmin(Admin admin) {
				
				AdminDao adminDao= new AdminDao();
				return adminDao.updateAdmin(admin);
				
			}
			
			public Admin getAdminById(int id) {
				
				AdminDao admindao = new AdminDao();
				return admindao.getAdminById(id);
			
			}
			public void getAllAdmin() {
			
				AdminDao admindao = new AdminDao();
				admindao.getAllAdmin();
			
			}
			
			public void deleteAdmin(int id) {
			
				AdminDao adminDao=new AdminDao();
				adminDao.deleteAdmin(id);
			
			}
			public void approveAdmin(int id ,String email,String password) {
			
				AdminDao adminDao=new AdminDao();
				adminDao.approveAdmin(id, email, password);
			
			}
			

}
