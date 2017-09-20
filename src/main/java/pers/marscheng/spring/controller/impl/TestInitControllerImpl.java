package pers.marscheng.spring.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pers.marscheng.spring.controller.ItestInitController;
import pers.marscheng.spring.service.ItestInitService;

@Controller("testInitController")
@RequestMapping("/controller/test/init")
public class TestInitControllerImpl implements ItestInitController {
	
	@Autowired
	private ItestInitService testInitService;

	public TestInitControllerImpl() {
		System.out.println("controler is init!");
	}
	
	@RequestMapping(value = "/testPost" , method = RequestMethod.POST)
	public String testPost(@RequestParam(name="name")String name){
		return name + "is success";
	}

}
