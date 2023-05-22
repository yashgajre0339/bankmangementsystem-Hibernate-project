package com.jsp.controller.Account;

import com.jsp.bank.dao.AccountDao;

public class GetAllAccount {
public static void main(String[] args) {
		
		AccountDao accountDao = new AccountDao();
		accountDao.getAllAccount();
	}

}
