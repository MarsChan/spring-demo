/**
 * @Description: TODO
 * @date: 2017年9月26日
 * @author: marscheng
 * @version: 1.0.0
 * @Copyright: 2017 marscheng 
 */
package pers.marscheng.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import pers.marscheng.spring.dao.IUserDao;
import pers.marscheng.spring.dto.User;
import pers.marscheng.spring.service.IUserService;

/**
 * @Description: TODO
 * @author: marscheng
 * @date:   2017年9月26日 下午6:58:51   
 *   
 */
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
    private IUserDao userDao;
	
	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
//	@Cacheable(cacheNames="isExists", key="#username")
	public boolean isExists(String username) {
		return userDao.isExists(username);
	}

}
