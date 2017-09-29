package pers.marscheng.spring.service.impl;

import org.springframework.stereotype.Service;

import pers.marscheng.spring.service.ItestInitService;

@Service("testInitServiceTwo")
public class TestInitServiceTwoImpl implements ItestInitService {

	public TestInitServiceTwoImpl() {
		System.out.println("I am two");
	}
	@Override
	public void test() {

	}

}
