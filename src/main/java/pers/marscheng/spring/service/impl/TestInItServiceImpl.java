package pers.marscheng.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.marscheng.spring.dao.ItestInitDao;
import pers.marscheng.spring.service.ItestInitService;

/**
 * @Description: 测试spring何时把bean加载实例化
 * @author: marscheng
 * @date: 2017年9月20日 下午8:12:01
 *
 */
@Service("testInItService")
// @Lazy(true)
public class TestInItServiceImpl implements ItestInitService {

	@Autowired
	private ItestInitDao testInitDao;

	public TestInItServiceImpl() {
		 System.out.println("service is init");
	}

	@Override
	public void test() {
		System.out.println("hello");
	}

}
