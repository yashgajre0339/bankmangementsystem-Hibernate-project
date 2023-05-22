package com.jsp.bank.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.bank.dto.Admin;
import com.jsp.bank.dto.BankManager;



public class AdminDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("yash");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();

public Admin saveAdmin(Admin admin) {
		
		
		if(admin!=null) {
		
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
		
		
		return admin;
		}
		else {
		return null;
		}

}

public Admin updateAdmin(Admin admin) {
	Admin a1 = entityManager.find(Admin.class, admin.getId());
	if(admin.getName() != null) {
		a1.setName(admin.getName());
	}
	if(admin.getEmail() != null) {
		a1.setEmail(admin.getEmail());
	}
	if(admin.getPassword() != null) {
		a1.setPassword(admin.getPassword());
	}
	if(a1 != null) {
		entityTransaction.begin();
		entityManager.merge(a1);
		entityTransaction.commit();
		System.out.println("Admin with ID: " + admin.getId() + " is updated");
	}else System.out.println("Update is failed");
	return admin;
}
public Admin getAdminById(int id) {
	Admin admin = entityManager.find(Admin.class, id);
	if(admin != null) {
		System.out.println();
		System.out.println("Admin Details");
		System.out.println();
		System.out.println(" ID is: " + admin.getId());
		System.out.println(" name is: " + admin.getName());
		System.out.println(" email is: " + admin.getEmail());
		System.out.println(" password is: " + admin.getPassword());
	}
	else System.out.println("This ID is not present");
	return admin;
}


public List<Admin> getAllAdmin() {
	String sql = "SELECT admin FROM Admin admin";
	Query query = entityManager.createQuery(sql);
	List<Admin> admin = query.getResultList();
	for(Admin admin1 : admin) {
		System.out.println();
		System.out.println("----====::::](==-- Admin Detail --==)[::::====----");
		System.out.println();
		System.out.println("Admin ID is: " + admin1.getId());
		System.out.println("Admin name is: " + admin1.getName());
		System.out.println("Admin email is: " + admin1.getEmail());
		System.out.println("Admin password is: " + admin1.getPassword());
	}
	return admin;
}
public void deleteAdmin(int id) {
	Admin admin = entityManager.find(Admin.class , id);
	if(admin != null) {
		entityTransaction.begin();
		entityManager.remove(admin);
		entityTransaction.commit();
		System.out.println("Admin ID as " + id + " has been deleted");
	} else System.out.println("incorrect  id");
}

public List<Admin> approveAdmin(int id, String email, String password) {
	String sql = "SELECT admin FROM Admin admin";
	Query query = entityManager.createQuery(sql);
	List<Admin> a = query.getResultList();
	for(Admin admin : a) {
		if(admin.getId()==id) {
			if(admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
				System.out.println("Admin logged in successfully");
				approveManager(id);
			}
			else {
				System.out.println("Email or Password is incorrect");
			}
		}
	}
	System.out.println("Admin with this ID dont exists");
	return a;
}
public List<BankManager> approveManager (int id) {
	Admin admin = entityManager.find(Admin.class , id);
	List<BankManager> bankmanager = null;
	BankMangerDao managerDao = new BankMangerDao();
	bankmanager = managerDao.getAllBankManager();
	for (BankManager m : bankmanager) {
		if (m.getStatus().equals("unapproved")) {
			m.setStatus("approved");
			m.setAdmin(admin);
			System.out.println("BankManager has been approved");
			entityTransaction.begin();
			entityManager.merge(m);
			entityTransaction.commit();
		}
	}
	return bankmanager;
}
}








