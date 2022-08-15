package com.ibsplc.jdbc.dao;

import java.util.ArrayList;
import java.util.List;

public class ProductDAOTest {
	
	public static void main(String[] args) {
		
		ProductDAO dao = new ProductDAOImpl();
		
//		boolean add = dao.addProduct(new Product(109,"FROOTI",10.00,80,"BEVERAGE"));
//		System.out.println(add);
		
//		Product newProduct = new Product();
//		newProduct = dao.getProduct(101);
//		System.out.println(newProduct);
		
//		boolean update = dao.updateProduct(104, 1000);
//		System.out.println(update);
		
//		boolean delete = dao.deleteProduct(109);
//		System.out.println(delete);
		
//		List<Product> categoryList = new ArrayList<Product>();
//		categoryList = dao.getProduct("BEVERAGE");
//		categoryList.forEach(p->{
//			System.out.println(p);
//		});
		
//		List<Product> priceList = new ArrayList<Product>();
//		priceList = dao.getProduct(40.00, 100000.00);
//		priceList.forEach(p -> {
//			System.out.println(p);
//		});
		
		List<Product> priceList = new ArrayList<Product>();
		priceList = dao.getProduct("ELECTRONICS",40.00, 100000.00);
		priceList.forEach(p -> {
			System.out.println(p);
		});
	}

}
