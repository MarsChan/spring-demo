package pers.marscheng.spring.dao.impl;

import org.springframework.stereotype.Component;

import pers.marscheng.spring.dao.ItestInitDao;

@Component("testInitDao")
public class TestInitDaoImpl implements ItestInitDao {

	
	public TestInitDaoImpl() {
		System.out.println("dao is init");
	}
	

}
