package pers.marscheng.spring.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.marscheng.spring.controller.ItestInitController;
import pers.marscheng.spring.service.ItestInitService;

/**
 * 测试注入控制层2
 *
 * @author marscheng
 * @create 2017-11-01 下午3:48
 */
@Controller("testInitTwoController")
@RequestMapping("/controller/two/init")
public class TestInitTwoControllerImpl implements ItestInitController{
    @Autowired
    @Qualifier("testInItService")
    private ItestInitService testInitService;

    @Override
    @RequestMapping(value = "/getTwoCode" , method = RequestMethod.GET)
    @ResponseBody
    public int getServiceHashCode() {
        return testInitService.hashCode();
    }
}
