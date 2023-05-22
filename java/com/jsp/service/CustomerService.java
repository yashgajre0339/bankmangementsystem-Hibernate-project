package com.jsp.service;

import java.util.List;

import com.jsp.bank.dao.CustomerDao;
import com.jsp.bank.dto.Account;
import com.jsp.bank.dto.Customer;

public class CustomerService {
	
		

		public Customer saveCustomer(Customer customer) {
			CustomerDao customerDao = new CustomerDao();
			return customerDao.saveCustomer(customer);
		}
		

		public Customer updateCustomer(Customer customer) {
			CustomerDao customerDao = new CustomerDao();
			return customerDao.updateCustomer(customer);
		}
		

		public Customer getCustomerById(int id) {
			CustomerDao customerDao = new CustomerDao();
			return customerDao.getCustomerById(id);
		}
		

		public void getAllCustomer() {
			CustomerDao customerDao = new CustomerDao();
			customerDao.getAllCustomer();
		}
		

		public void deleteCustomer(int id) {
			CustomerDao customerDao = new CustomerDao();
			customerDao.deleteCustomer(id);
		}
		

		public 	Account saveAccount(int customer_id, Account account) {
			CustomerDao customerDao = new CustomerDao();
			return customerDao.saveAccount(customer_id, account);
		}
		
		public List<Account > getAccountById(int customer_id){
			CustomerDao customerDao = new CustomerDao();
			return customerDao.getAccountById(customer_id);
		}
		

}
