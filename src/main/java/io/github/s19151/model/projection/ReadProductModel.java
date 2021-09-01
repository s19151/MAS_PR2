package io.github.s19151.model.projection;

import io.github.s19151.model.Product;
import io.github.s19151.model.ProductType;

public class ReadProductModel {
	private long id;
	private String name;
	private double price;
	private String description;
	private ProductType productType;
	private String code;

	public ReadProductModel(Product source) {
		this.id = source.getId();
		this.name = source.getName();
		this.price = source.getPrice();
		this.description = source.getDescription();
		this.productType = source.getProductType();
		this.code = source.getCode();
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ProductType getProductType() {
		return productType;
	}
	
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
}
