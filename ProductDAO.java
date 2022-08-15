package com.ibsplc.jdbc.dao;

import java.util.List;

public interface ProductDAO {
	
	public boolean addProduct(int productCode, String productName, double unitPrice, int quantity, String category);
	public boolean addProduct(Product product);
	public boolean updateProduct(int productCode, double newPrice);
	public boolean deleteProduct(int productCode);
	
	public Product getProduct(int productCode);
	
	public List<Product> getProduct(String category);
	public List<Product> getProduct(double lowPrice, double maxPrice);
	public List<Product> getProduct(String category, double lowPrice, double maxPrice);
	
}
