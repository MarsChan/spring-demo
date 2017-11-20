package pers.marscheng.spring.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pers.marscheng.spring.dao.SystemUserDao;
import pers.marscheng.spring.dto.SysUserEntity;

import java.util.Set;

/**
 * 用户数据交互层
 *
 * @author marscheng
 * @create 2017-11-16 下午6:59
 */
@Repository
public class SystemUserDaoImpl implements SystemUserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public SysUserEntity createUser(SysUserEntity user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
        return user;
    }

    @Override
    public void changePassword(String userCode, String newPassword) {

    }

    @Override
    public SysUserEntity findByUsercode(String userCode) {
        return null;
    }

    @Override
    public Set<String> findRoles(String userCode) {
        return null;
    }

    @Override
    public Set<String> findPermissions(String userCode) {
        return null;
    }
}
