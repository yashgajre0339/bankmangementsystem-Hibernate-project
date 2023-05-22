package com.jsp.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.bank.dto.Account;
import com.jsp.bank.dto.Customer;

public class CustomerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("yash");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
		

	public Customer saveCustomer(Customer customer) {
		List<Customer> customer1 = getAllCustomer();
		for(Customer c1 : customer1) {
			if(c1.getAadhar_no().equals(customer.getAadhar_no())       ) {
				System.out.println(" Aadhar No. "+customer.getAadhar_no()+" already exists");
				return null;
			}
		}
		customer.setStatus("unapproved");
		
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
		return customer;
	}
	

	public Customer updateCustomer(Customer customer) {
		Customer c3 = entityManager.find(Customer.class, customer.getId());
		if(customer.getName() != null) {
			c3.setName(customer.getName());
			System.out.println("Customer name has been updated");
		}
		if(customer.getAddress() != null) {
			c3.setAddress(customer.getAddress());
			System.out.println("Address has been updated ");
		}
		if(customer.getAadhar_no() != null) {
			c3.setAadhar_no(customer.getAadhar_no());
			System.out.println("Aadhar n.o has been updated");
		}
		if(customer.getStatus() != null) {
			c3.setStatus(customer.getStatus());
			System.out.println("Status has been updated");
		}
		if(c3 != null) {
			entityTransaction.begin();
			entityManager.merge(c3);
			entityTransaction.commit();
			System.out.println("This id "+ customer.getId() + " has been updated");
		}else System.out.println("Not Updated");
		return customer;
	}
	

	public Customer getCustomerById(int id) {
		Customer customer = entityManager.find(Customer.class, id);
		if(customer != null) {
			System.out.println();
			System.out.println(" Customer Details");
			System.out.println();
			System.out.println("Customer ID is: " + customer.getId());
			System.out.println("Customer Name is: " + customer.getName());
			System.out.println("Customer Address is: " + customer.getAddress());
			System.out.println("Customer Adhar No. is: " + customer.getAadhar_no());
			System.out.println("Customer status is: " + customer.getStatus());
		}
		else System.out.println("Invalid ID");
		return customer;
	}
	

	public List<Customer> getAllCustomer() {
		String sql = "SELECT customer FROM Customer customer";
		Query query = entityManager.createQuery(sql);
		List<Customer> c = query.getResultList();
		for(Customer customer : c) {
			System.out.println();
			System.out.println(" Customer Details");
			System.out.println();
			System.out.println("Customer ID is: " + customer.getId());
			System.out.println("Customer Name is: " + customer.getName());
			System.out.println("Customer Address is: " + customer.getAddress());
			System.out.println("Customer Adhar No. is: " + customer.getAadhar_no());
			System.out.println("Customer status is: " + customer.getStatus());
		}
		return c;
	}
	

	public void deleteCustomer(int id) {
		Customer customer = entityManager.find(Customer.class , id);
		entityTransaction.begin();
		entityManager.remove(customer);
		entityTransaction.commit();
		System.out.println("Customer with ID as " + id + " has been deleted");
	}
	

	public Account saveAccount(int customer_id, Account account) {
		String sql = "SELECT account FROM Account account";
		Query query = entityManager.createQuery(sql);
		List <Account> accou = query.getResultList();
		for(Account account1 : accou) {			
			if(account1.getCustomer().getId() == customer_id) {
				System.out.println("Account with id as " + customer_id + " already exists");
				return null;
			}
		}
		Customer customer = entityManager.find(Customer.class , customer_id);
		if(customer != null) {
			if(customer.getStatus().equals("approved")) {
				account.setAccountno(1276534 + customer.getId());
				account.setIfsc_code("BOI16087625");
				account.setBranch("Panvel");
				account.setBalance(10000);
				account.setCustomer(customer);
				entityTransaction.begin();
				entityManager.persist(account);
				entityTransaction.commit();
				System.out.println("Account  added successfuly");
			}else System.out.println("You are not an approved Customer");
		}else System.out.println("Customer not found");
		return account;
	}
	
	public List<Account> getAccountById(int customer_id){
		String sql = "SELECT account FROM Account account";
		Query query = entityManager.createQuery(sql);
		List<Account> a = query.getResultList();
		for(Account account : a) {
			if(account.getCustomer().getId() == customer_id) {
				System.out.println();
				System.out.println(" Account Details");
				System.out.println();
				System.out.println("Account id is :- " + account.getId());
				System.out.println("Account number is :- " + account.getAccountno());
				System.out.println("Bank branch name is :- " + account.getBranch());
				System.out.println("Bank Ifsc code is :- " + account.getIfsc_code());
				System.out.println("Your bank balance is :- Rs " + account.getBalance());
			}
		}
		return a;
	}

	}


