package com.ssm.dao;

import java.util.List;

import com.ssm.model.Account;

public interface IAccountDao {
	public List<Account> findAccounts();
}
