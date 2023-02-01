package com.minifinance.ltd.entity;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Products {
	@Id
private String id;
private String productName;
private String productDescription;
private String productImage;
private double productCharge;
private String productType;

public Products(String id, String productName, String productDescription, String productImage, double productCharge,
		String productType, Users users) {
	super();
	this.id = id;
	this.productName = productName;
	this.productDescription = productDescription;
	this.productImage = productImage;
	this.productCharge = productCharge;
	this.productType = productType;
	this.users = users;
}

@JsonIgnore
@ManyToOne
private Users users;



public String getProductType() {
	return productType;
}

public void setProductType(String productType) {
	this.productType = productType;
}

public Products() {
	super();
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public String getProductDescription() {
	return productDescription;
}

public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}

public String getProductImage() {
	return productImage;
}

public void setProductImage(String productImage) {
	this.productImage = productImage;
}

public double getProductCharge() {
	return productCharge;
}

public void setProductCharge(double productCharge) {
	this.productCharge = productCharge;
}

public Users getUsers() {
	return users;
}

public void setUsers(Users users) {
	this.users = users;
}

@Override
public String toString() {
	return "Products [id=" + id + ", productName=" + productName + ", productDescription=" + productDescription
			+ ", productImage=" + productImage + ", productCharge=" + productCharge + ", productType=" + productType
			+ ", users=" + users + "]";
}





}
