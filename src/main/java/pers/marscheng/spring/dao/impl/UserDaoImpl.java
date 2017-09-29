/**
 * @Description: TODO
 * @date: 2017年9月26日
 * @author: marscheng
 * @version: 1.0.0
 * @Copyright: 2017 marscheng 
 */
package pers.marscheng.spring.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pers.marscheng.spring.dao.IUserDao;
import pers.marscheng.spring.dto.User;

/**
 * @Description: 用户Dao层
 * @author: marscheng
 * @date:   2017年9月26日 下午6:39:28   
 *   
 */
@Repository
public class UserDaoImpl implements IUserDao {
	//注入sessionFactory
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<User>();
        String hsql="from User";
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery(hsql);
        userList = query.getResultList();
        return userList;
    }

    @Override
    public boolean isExists(String username) {
        Query<User> query = sessionFactory.openSession()
                .createQuery("from User u where u.username = :username").setParameter("username", username);
        System.out.println(query.getResultList().size());
        return query.getResultList().size()>0?true:false;
    }

}
