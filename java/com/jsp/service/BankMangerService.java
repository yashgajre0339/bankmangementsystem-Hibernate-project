package com.jsp.service;

import com.jsp.bank.dao.BankMangerDao;
import com.jsp.bank.dto.BankManager;
import com.jsp.bank.dto.Customer;

public class BankMangerService {

	public BankManager saveBankManager(BankManager bankmanager) {
		BankMangerDao bankmanagerDao = new BankMangerDao();
		return bankmanagerDao.saveBankManager(bankmanager);
	}
	

	public BankManager updateBankManager(BankManager bankmanager) {
		BankMangerDao bankmanagerDao = new BankMangerDao();
		return bankmanagerDao.updateBankManager(bankmanager);
	}
	

	public BankManager getBankManagerById(int id) {
		BankMangerDao bankmanagerDao = new  BankMangerDao();
		return bankmanagerDao.getBankManagerById(id);
	}
	

	public void getAllBankManager() {
		BankMangerDao bankmanagerDao = new BankMangerDao();
		bankmanagerDao.getAllBankManager();
	}
	

	public void deleteBankManager(int id) {
		BankMangerDao bankmanagerDao = new BankMangerDao();
		bankmanagerDao.deleteBankManager(id);
	}
	

	public void approveManager(BankManager bankmanager) {
		BankMangerDao bankmanagerDao = new BankMangerDao();
		bankmanagerDao.approveBankManager(bankmanager);
	}
	

	public Customer deleteCustomer(int bankmanager_id, int customer_id) {
		BankMangerDao bankmanagerDao = new BankMangerDao();
		return bankmanagerDao.deleteCustomer(bankmanager_id, customer_id);
	}
}
