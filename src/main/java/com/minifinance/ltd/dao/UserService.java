package com.minifinance.ltd.dao;

import java.util.Map;

import com.minifinance.ltd.entity.Users;

public interface UserService {
	public Users saveUser(Users user);

	public Users getUserById(int userId);

	public Users getUserByUserName(String userName);

	public Map<String, Object> deleteUserById(int userId);

	public Users updateUserById(int userId);
}
