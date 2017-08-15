package com.ssm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import java.util.List;

import com.ssm.dao.IAccountDao;
import com.ssm.model.Account;
import com.ssm.service.Imp.IAdminService;

@Service("adminService")
public class AdminService implements IAdminService{
	
	@Resource
	private IAccountDao respository;
	
	public List<Account> findAccounts() {
		return respository.findAccounts();
	}

}
