package com.douineau.testspringboot.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Laptop {
	
	@Id
	private Integer id;
	private UUID uuid;
	private String brand;
	private float price;
	
	public Laptop() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Laptop [id=" + id + ", uuid=" + uuid + ", brand=" + brand + ", price=" + price + "]";
	}
	
	
	

}
