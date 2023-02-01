package com.minifinance.ltd.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minifinance.ltd.dao.ProductService;
import com.minifinance.ltd.dao.UserService;
import com.minifinance.ltd.entity.Products;
import com.minifinance.ltd.entity.Users;

@RestController
@RequestMapping("/api/v1/services")
@CrossOrigin(origins = {"*"})
public class Controller {

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	

	@GetMapping("/getUserById/{userId}")
	public Users getUserById(@PathVariable int userId) {
		return this.userService.getUserById(userId);
	}

	@GetMapping("/getUserByUserName/{userName}")
	public Users getUserByUserName(@PathVariable String userName) {
		return this.userService.getUserByUserName(userName);
	}

	//@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/saveProduct/{userId}")
	public Products insertProducts(@RequestBody Products products, @PathVariable String userId) {
		
		return this.productService.insertProducts(products, Integer.parseInt(userId));
	}

	@GetMapping("/allProducts")
	public List<Products> getAllProducts() {
		System.out.println(">>>>>");
		return this.productService.getAllProducts();
	}

	@GetMapping("/getProductById/{id}")
	public Products getProductById(@PathVariable String id) {
		return this.productService.getByProductsId(id);
	}
	
	@DeleteMapping("/removeItem/{id}")
	public Map<String, Object> removeItem(@PathVariable String id) {
		System.out.println("inside removeItem");
		return this.productService.removeProduct(id);
	}

}
