package pers.marscheng.spring.dao;

import java.util.List;

import pers.marscheng.spring.dto.User;

public interface IUserDao {
	// 得到所有用户
    public List<User> getAllUser();

    // 检测用户名是否存在
    public boolean isExists(String username);
}
