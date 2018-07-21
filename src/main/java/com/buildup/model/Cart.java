package com.buildup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartID;
	
	@Column
	private int did;
	
	@Column
	private float price;
	
	@Column
	private String name;
	
	@Column
	private float total;
	
	
	@Column
	private int orderID;

     @Column
     private String description;
	
public Cart()
{}



public int getCartID() {
	return cartID;
}



public void setCartID(int cartID) {
	this.cartID = cartID;
}



public int getDid() {
	return did;
}



public void setDid(int did) {
	this.did = did;
}



public float getPrice() {
	return price;
}



public void setPrice(float price) {
	this.price = price;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public float getTotal() {
	return total;
}



public void setTotal(float total) {
	this.total = total;
}







public int getOrderID() {
	return orderID;
}



public void setOrderID(int orderID) {
	this.orderID = orderID;
}



public String getDescription() {
	return description;
}



public void setDescription(String description) {
	this.description = description;
}






}