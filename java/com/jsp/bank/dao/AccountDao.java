package com.jsp.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.bank.dto.Account;

public class AccountDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("yash");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	

	public Account saveAccount(Account account) {
		account.setBalance(1234);
		entityTransaction.begin();
		entityManager.persist(account);
		entityTransaction.commit();
		return account;
	}
	
	public Account updateAccount(Account account) {
		Account a2 = entityManager.find(Account.class, account.getId());
		if(account.getAccountno() != 0) {
			a2.setAccountno(account.getAccountno());
		}
		if(account.getBranch() != null) {
			a2.setBranch(account.getBranch());
		}
		if(account.getBalance() != 0.0) {
			a2.setBalance(account.getBalance());
		}
		if(account.getIfsc_code() != null) {
			a2.setIfsc_code(account.getIfsc_code());
		}		
		if (a2 != null) {
			entityTransaction.begin();
			entityManager.merge(a2);
			entityTransaction.commit();
			System.out.println("Account updated successfuly");
		}else System.out.println(" Not updated");
		return account;
	}
	

	public Account getAccountById(int id) {
		Account account = entityManager.find(Account.class , id);
		if(account != null) {
			System.out.println();
			System.out.println(" Account Details");
			System.out.println();
			System.out.println("Account id is :- " + account.getId());
			System.out.println("Account number is :- " + account.getAccountno());
			System.out.println("Bank branch name is :- " + account.getBranch());
			System.out.println("Bank Ifsc code is :- " + account.getIfsc_code());
			System.out.println("Your bank balance is :- Rs " + account.getBalance());
		}else System.out.println("Invalid ID");
		return account;
	}
	

	public List<Account> getAllAccount() {
		String sql = "SELECT account FROM Account account";
		Query query = entityManager.createQuery(sql);
		List<Account> account = query.getResultList();
		for(Account a : account) {
			System.out.println();
			System.out.println(" Account Details");
			System.out.println();
			System.out.println("Account id is :- " + a.getId());
			System.out.println("Account number is :- " + a.getAccountno());
			System.out.println("Bank branch name is :- " + a.getBranch());
			System.out.println("Bank Ifsc code is :- " + a.getIfsc_code());
			System.out.println("Your bank balance is :- Rs" + a.getBalance());
		}
		return account;
	}

}
