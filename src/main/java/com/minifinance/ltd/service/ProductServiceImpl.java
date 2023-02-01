package com.minifinance.ltd.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minifinance.ltd.dao.ProductService;
import com.minifinance.ltd.entity.Products;
import com.minifinance.ltd.entity.Users;
import com.minifinance.ltd.repo.ProductRepository;
import com.minifinance.ltd.repo.UserRepository;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Products insertProducts(Products products,int userId) {
		// TODO Auto-generated method stub
		products.setId(UUID.randomUUID().toString());
		Users users=this.userRepository.findById(userId).get();
		products.setUsers(users);
		return this.productRepository.save(products);
	}

	@Override
	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
		return this.productRepository.findAll();
	}

	@Override
	public Products getByProductsId(String productId) {
		// TODO Auto-generated method stub

		return this.productRepository.findById(productId).get();
	}

	@Override
	public Map<String, Object> removeProduct(String productId) {
		// TODO Auto-generated method stub
		this.productRepository.deleteById(productId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Product Deleted Successfully.");
		map.put("status", "Success");
		return map;
	}

}
