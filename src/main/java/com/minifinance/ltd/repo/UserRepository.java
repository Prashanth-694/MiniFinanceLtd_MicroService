package com.minifinance.ltd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minifinance.ltd.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

	Users findByUserName(String userName);
	
}
