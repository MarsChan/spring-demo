package pers.marscheng.spring.service;

import java.util.List;

import pers.marscheng.spring.dto.User;

public interface IUserService {
	public List<User> getAllUser();
    public boolean isExists(String username);
}
