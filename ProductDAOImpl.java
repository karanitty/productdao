package com.ibsplc.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO{

	public boolean addProduct(int productCode, String productName, double unitPrice, int quantity, String category) {
		
		boolean insertStatus = false;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			
			if(con != null) {
				
					PreparedStatement pstmt = con.prepareStatement("INSERT INTO PRODUCT VALUES(?,?,?,?,?)");
					pstmt.setInt(1, productCode);
					pstmt.setString(2, productName);
					pstmt.setDouble(3, unitPrice);
					pstmt.setInt(4, quantity);
					pstmt.setString(5, category);
					int result = pstmt.executeUpdate();
					if(result == 1) {
						insertStatus = true;
						System.out.println("Row added");
					}
					else {
						System.out.println("Query execution failed");
					}
					con.close();
			}
		}
		catch (SQLException e) {

			e.printStackTrace();
			
		}
		return insertStatus;
	}

	
	public boolean addProduct(Product product) {
		return addProduct(product.getProductCode(), product.getProductName(), product.getUnitPrice(), product.getQuantity(), product.getCategory());
	}

	
	
	@Override
	public boolean updateProduct(int productCode, double newPrice) {
		
		boolean updateStatus = false;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			
			if(con != null) {
				PreparedStatement pstmt = con.prepareStatement("UPDATE PRODUCT SET UNITPRICE = ? WHERE PRODUCTCODE = ?");
				pstmt.setDouble(1, newPrice);
				pstmt.setInt(2, productCode);
				int result = pstmt.executeUpdate();
				if(result==1) {
					System.out.println("Row updated");
					updateStatus = true;
				}
				else {
					System.out.println("Row updation unsuccessful");
				}
			}
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return updateStatus;
	}

	
	
	@Override
	public boolean deleteProduct(int productCode) {
		
		boolean deleteStatus = false;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			
			if(con != null) {
				PreparedStatement pstmt = con.prepareStatement("DELETE FROM PRODUCT WHERE PRODUCTCODE = ?");
				pstmt.setInt(1,productCode);
				int result = pstmt.executeUpdate();
				if(result == 1) {
					System.out.println("Row deleted");
					deleteStatus = true;
				}
			}
		}
		
		catch (SQLException e) {
			e.getStackTrace();
		}
		
		return deleteStatus;
	}

	
	
	@Override
	public Product getProduct(int productCode) {
		
		Product newProduct = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			
			if(con != null) {
				PreparedStatement pstmt = con.prepareStatement("SELECT PRODUCTCODE, PRODUCTNAME, UNITPRICE, QUANTITY, CATEGORY FROM PRODUCT WHERE PRODUCTCODE=?");
				pstmt.setInt(1, productCode);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					newProduct = new Product();
					newProduct.setProductCode(rs.getInt(1));
					newProduct.setProductName(rs.getString(2));
					newProduct.setUnitPrice(rs.getDouble(3));
					newProduct.setQuantity(rs.getInt(4));
					newProduct.setCategory(rs.getString(5));
					
					con.close();
					return newProduct;
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getProduct(String category) {
		
		List<Product> newList = new ArrayList<Product>();
		Product newProduct = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("SELECT PRODUCTCODE, PRODUCTNAME, UNITPRICE, QUANTITY, CATEGORY FROM PRODUCT WHERE CATEGORY = ?");
			pstmt.setString(1, category);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				newProduct = new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getString(5));
				newList.add(newProduct);
			}
			
			con.close();
		}
		
		catch(SQLException e) {
			e.getStackTrace();
		}
		
	
		return newList;
	}

	@Override
	public List<Product> getProduct(double lowPrice, double maxPrice) {
		
		List<Product> newList = new ArrayList<Product>();
		Product newProduct = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("SELECT PRODUCTCODE, PRODUCTNAME, UNITPRICE, QUANTITY, CATEGORY FROM PRODUCT WHERE UNITPRICE BETWEEN ? AND ?");
			pstmt.setDouble(1, lowPrice);
			pstmt.setDouble(2, maxPrice);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				newProduct = new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getString(5));
				newList.add(newProduct);
			}
		}
		catch(SQLException e) {
			e.getStackTrace();
		}
		return newList;
	}

	@Override
	public List<Product> getProduct(String category, double lowPrice, double maxPrice) {
		
		List<Product> newList = new ArrayList<Product>();
		Product newProduct = null;
		
		try {
			Connection con = ConnectionUtil.getConnection();
			
			PreparedStatement pstmt = con.prepareStatement("SELECT PRODUCTCODE, PRODUCTNAME, UNITPRICE, QUANTITY, CATEGORY FROM PRODUCT WHERE CATEGORY = ? AND UNITPRICE BETWEEN ? AND ?");
			pstmt.setString(1, category);
			pstmt.setDouble(2, lowPrice);
			pstmt.setDouble(3, maxPrice);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				newProduct = new Product(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getString(5));
				newList.add(newProduct);
			}
		}
		
		catch(SQLException e) {
			e.getStackTrace();
		}
		return newList;
	}

}
