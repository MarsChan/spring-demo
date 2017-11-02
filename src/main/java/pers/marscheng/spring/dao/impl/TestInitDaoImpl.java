package pers.marscheng.spring.dao.impl;

import org.springframework.stereotype.Component;

import pers.marscheng.spring.dao.ItestInitDao;
/**
 * @Description: 测试spring何时把bean加载实例化
 * @author: marscheng
 * @date:   2017年9月20日 下午8:11:48   
 *
 */
@Component("testInitDao")
//懒加载如果加上@Autowired就会失效
//@Lazy(true)
public class TestInitDaoImpl implements ItestInitDao {

	
	//public TestInitDaoImpl() {
	//	System.out.println("dao is init");
	//}
	

}
