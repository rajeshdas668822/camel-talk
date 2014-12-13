package org.apache.camel.example.restlet.pojo;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;


public class Product implements Serializable {
	
	@SerializedName("name")
	private String name;
	@SerializedName("description")
	private String description;
	
	@SerializedName("price")
	private String price;
	@SerializedName("category")
	private String category;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	

}
