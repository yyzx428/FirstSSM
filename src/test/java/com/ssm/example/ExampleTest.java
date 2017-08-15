package com.ssm.example;

import java.util.List;
import java.util.ListIterator;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.model.Account;
import com.ssm.service.Imp.IAdminService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-mybatis.xml"})
public class ExampleTest {
	private static Logger logger=Logger.getLogger(ExampleTest.class);
	
	@Resource
	private IAdminService adminService;
	
	@Test
	public void test() {
		List<Account> accounts=adminService.findAccounts();
		ListIterator<Account> iterator=accounts.listIterator();
		while(iterator.hasNext()) {
			logger.info(iterator.next().toString());
		}
	}
 }
