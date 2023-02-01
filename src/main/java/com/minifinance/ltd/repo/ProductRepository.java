package com.minifinance.ltd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minifinance.ltd.entity.Products;

public interface ProductRepository extends JpaRepository<Products, String>{

}
