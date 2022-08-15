package com.ibsplc.jdbc.dao;

public class Product {
	
	private int productCode;
	private String productName;
	private double unitPrice;
	private int quantity;
	private String category;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int productCode, String productName, double unitPrice, int quantity, String category) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.category = category;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", unitPrice=" + unitPrice
				+ ", quantity=" + quantity + ", category=" + category + "]";
	}
	
	

}
