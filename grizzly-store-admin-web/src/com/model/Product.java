package com.model;

public class Product {
	
	int id;
	String name;
	String category;
	String description;
	int price;
	
	public Product() {
	
		
	}
	public Product(String name, String category, String description, int price) {
		
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
	}
	
	
	public Product(int id, String name, String category, String description, int price) {
	
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", description=" + description
				+ ", price=" + price + "]";
	}
	
	
	
	
	
}
