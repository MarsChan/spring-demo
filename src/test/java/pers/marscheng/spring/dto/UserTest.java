package pers.marscheng.spring.dto;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;
import pers.marscheng.spring.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/spring-mvc.xml")
public class UserTest extends TestCase {
	@Autowired
    private IUserService userService;
	@Test
	@Ignore
	public void testInsert(){
		//使用此方法获取并初始化我们的spring容器，注意spring-datasource.xml必须存放在类路径的根目录下。
	    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
	    //从spring容器中获取我们的会话工厂实例，里面已完成好各个属性的配置工作
	    SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");

	    //下面开始我们的数据库操作
	    Session session = sessionFactory.openSession();//从会话工厂获取一个session
	    Transaction transaction = session.beginTransaction();//开启一个新的事务
	    User user = new User();
	    user.setName("marscheng");
	    user.setPassWord("123456");
	    session.save(user);
	    transaction.commit();//提交事务
	}
	
	@Test
	public void testSearch(){
		List<User> userList = userService.getAllUser();
        for(User user:userList){
            System.out.println(user.getName());
        }
	}
}
