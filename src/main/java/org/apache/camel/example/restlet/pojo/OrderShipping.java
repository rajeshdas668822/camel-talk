package org.apache.camel.example.restlet.pojo;

import java.io.Serializable;

public class OrderShipping implements Serializable {
	
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;
	private boolean giftwarp;
	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public boolean isGiftwarp() {
		return giftwarp;
	}
	public void setGiftwarp(boolean giftwarp) {
		this.giftwarp = giftwarp;
	}
	
	
}
