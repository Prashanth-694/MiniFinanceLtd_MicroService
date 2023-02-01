package com.minifinance.ltd.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.minifinance.ltd.dao.UserService;
import com.minifinance.ltd.entity.Users;
import com.minifinance.ltd.exception.UserNotFoundException;
import com.minifinance.ltd.repo.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Users getUserById(int userId) {
		// TODO Auto-generated method stub

		return this.userRepository.findById(userId).orElseThrow(()->
			new UserNotFoundException("User not found with "+ userId)
		);
	}

	@Override
	public Users getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUserName(userName);
	}

	@Override
	public Map<String, Object> deleteUserById(int userId) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(userId);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("message", "User Deleted Successfully.");
		map.put("status", "Success");
		return map;
	}

	@Override
	public Users updateUserById(int userId) {
		
		return null;
	}

	@Override
	public Users saveUser(Users user) {
		user.setUserRegDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM.yyyy HH:mm:ss")));
		user.setUserRole("NORMAL");
		user.setUserPassword(passwordEncoder.encode(user.getPassword()));
		return this.userRepository.save(user);
	}

}
