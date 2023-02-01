package com.minifinance.ltd.dao;

import java.util.List;
import java.util.Map;

import com.minifinance.ltd.entity.Products;

public interface ProductService {
public Products insertProducts(Products products,int userId);
public List<Products> getAllProducts();
public Products getByProductsId(String productId);
public Map<String, Object> removeProduct(String productId);
}
