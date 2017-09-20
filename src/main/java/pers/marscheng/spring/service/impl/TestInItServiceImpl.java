package pers.marscheng.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.marscheng.spring.dao.ItestInitDao;
import pers.marscheng.spring.service.ItestInitService;

@Service("testInItService")
public class TestInItServiceImpl implements ItestInitService {

	@Autowired
	private ItestInitDao testInitDao;
	
	public TestInItServiceImpl() {
		System.out.println("service is init");
	}

}
