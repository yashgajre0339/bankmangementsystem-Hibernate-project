package com.jsp.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.bank.dto.BankManager;
import com.jsp.bank.dto.Customer;

public class BankMangerDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("yash");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
//	save manager
	public BankManager saveBankManager(BankManager manager) {
		manager.setStatus("unapproved");
		System.out.println("Please wait for the Admin to approve BankManager");
		entityTransaction.begin();
		entityManager.persist(manager);
		entityTransaction.commit();
		return manager;
	}
	
//	update manager
	public BankManager updateBankManager(BankManager bankmanager) {
		BankManager bm = entityManager.find(BankManager.class, bankmanager.getId());
		if(bankmanager.getName() != null) {
			bm.setName(bankmanager.getName());
		}
		if(bankmanager.getEmail() != null) {
			bm.setEmail(bankmanager.getEmail());
		}
		if(bankmanager.getPassword() != null) {
			bm.setPassword(bankmanager.getPassword());
		}
		if(bm != null) {
			entityTransaction.begin();
			entityManager.merge(bm);
			entityTransaction.commit();
			System.out.println(" ID as "+ bankmanager.getId() + " has been updated in BankManger");
		}else System.out.println(" Not updated");
		return bankmanager;
	}
	
//	get manager by id
	public BankManager getBankManagerById(int id) {
		BankManager bm2 = entityManager.find(BankManager.class, id);
		if(bm2 != null) {
			System.out.println();
			System.out.println(" BankManager Details");
			System.out.println();
			System.out.println("BankManager ID is: " + bm2.getId());
			System.out.println("BankManager name is: " + bm2.getName());
			System.out.println("BankManager email is: " + bm2.getEmail());
			System.out.println("BankManager password is: " + bm2.getPassword());
			System.err.println("BankManager status is: " + bm2.getStatus());
		}
		else System.out.println("BankManager ID dont exist");
		return bm2;
	}
	
//	get all manager
	public List<BankManager> getAllBankManager() {
		String sql = "SELECT bankmanager FROM BankManager bankmanager";
		Query query = entityManager.createQuery(sql);
		List<BankManager> bankmanager = query.getResultList();
		for(BankManager bm3 : bankmanager) {
			System.out.println();
			System.out.println("BankManager Details");
			System.out.println(bm3.getId());
			System.out.println(bm3.getName());
			System.out.println(bm3.getEmail());
			System.out.println(bm3.getPassword());
			System.out.println(bm3.getStatus());
		}
		return bankmanager;
	}
	
//	delete manager by id
	public void deleteBankManager(int id) {
		BankManager bankmanager = entityManager.find(BankManager.class , id);
		entityTransaction.begin();
		entityManager.remove(bankmanager);
		entityTransaction.commit();
		System.out.println(" ID as " + id + " has been deleted in BankManger");
	}
	
//	approve manager
	public List<BankManager> approveBankManager(BankManager bankmanager) {
		String sql = "SELECT bankmanager FROM BankManager bankmanager";
		Query query = entityManager.createQuery(sql);
		List<BankManager> m = query.getResultList();
		for(BankManager bankmanager1 : m) {
			if(bankmanager1.getId() == bankmanager.getId()) {
				if(bankmanager1.getEmail().equals(bankmanager.getEmail()) && bankmanager1.getPassword().equals(bankmanager.getPassword())) {
					System.out.println("BankManager logged in successfully");
					approveCustomer(bankmanager.getId());
				}
				else {
					System.out.println("Email or Password did not matched");
				}
			}
		}
		return m;
	}
	
//	approve customer
	public List<Customer> approveCustomer (int id) {
		BankManager bankmanager = entityManager.find(BankManager.class , id);
		List<Customer> customer = null;
		CustomerDao customerDao = new CustomerDao();
		customer = customerDao.getAllCustomer();
			for (Customer c : customer) {
				if (c.getStatus().equals("unapproved")) {
					c.setStatus("approved");
					c.setBankmanger(bankmanager);
					System.out.println("Customer  Approved");
					entityTransaction.begin();
					entityManager.merge(c);
					entityTransaction.commit();
				}
			}
		return customer;
	}
	
//	delete customer by id
	public Customer deleteCustomer(int manager_id, int customer_id) {
		BankManager manager = entityManager.find(BankManager.class , manager_id);
		Customer customer = entityManager.find(Customer.class , customer_id);
		if(manager != null) {
			if(customer != null) {
				if(customer.getBankmanger().getId() == manager_id) {
					entityTransaction.begin();
					entityManager.remove(customer);
					entityTransaction.commit();
					System.out.println("Customer has been removed");
				} else System.out.println(customer.getName() + " is not your customer");
			} else System.out.println("Invalid Customer id");
		} else System.out.println("Invalid Manager id");
		return customer;
	}
}
