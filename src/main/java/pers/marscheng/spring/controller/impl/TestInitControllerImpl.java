package pers.marscheng.spring.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.marscheng.spring.controller.ItestInitController;
import pers.marscheng.spring.service.ItestInitService;

/**
 * @Description: 测试spring何时把bean加载实例化
 * @author: marscheng
 * @date:   2017年9月20日 下午8:10:38   
 *
 */
@Controller("testInitController")
@RequestMapping("/controller/test/init")
public class TestInitControllerImpl implements ItestInitController {
	
//	@Autowired
	private ItestInitService testInitService;
	
//	@Autowired
//	BeanFactory beanFactory;

	public TestInitControllerImpl() {
		System.out.println("controler is init sssss!");
	}
	
	@RequestMapping(value = "/testPost" , method = RequestMethod.POST)
	@ResponseBody
	public String testPost(@RequestParam(name="name")String name){
//		System.out.println("before");
//		TestInItServiceImpl testInitService = (TestInItServiceImpl)beanFactory.getBean("testInItService");
		testInitService.test();
		return name + "is success";
	}

}
