package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import domin.Product;

public class ProductDao {


	public List<Product> viewAllProduct() throws SQLException  {
		Connect	con = null;
		PreparedStatement preSta = null;
		try {	
			
			con = new Connect();
			String sql = "SELECT * FROM `products`";
			preSta =  con.c.prepareStatement(sql);			
			ResultSet res =  preSta.executeQuery();
			List<Product> listOp = new ArrayList<Product>();
			
			while(res.next()){
				Product product = new Product();
				
				product.setProductId(res.getInt("productID"));
				product.setProductName(res.getString("productName"));
				product.setCompanyName(res.getString("companyName"));
				product.setOperatingSystem(res.getString("operatingSystem"));
				product.setBattery(res.getString("battery"));
				product.setProcessor(res.getString("processor"));
				product.setDescription(res.getString("description"));
				
				listOp.add(product);
			}
			
			return listOp;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

				
	}// End viewAllProduct



	public Product viewProSpe(int proId) throws SQLException  {
		
		Connect con = null;
		Product product = null;
		
		try {
			
			con = new Connect();
			
			String sql = "SELECT * FROM `products` WHERE `productID` = ?";
			
			product = new Product();
			
			PreparedStatement stat = con.c.prepareStatement(sql);
			
			stat.setInt(1, proId);
	
			ResultSet res = stat.executeQuery();
			
			
			while(res.next()){
				
				product.setProductId(res.getInt("productID"));
				product.setProductName(res.getString("productName"));
				product.setCompanyName(res.getString("companyName"));
				product.setOperatingSystem(res.getString("operatingSystem"));
				product.setBattery(res.getString("battery"));
				product.setProcessor(res.getString("processor"));
				product.setDescription(res.getString("description"));
				
			}
			
			
			return product;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
			
	}//End viewProSpe
	
	
	public void addProduct(Product pro) throws ClassNotFoundException, SQLException {
		
		
		Connect con = new Connect();
		
		String sql = "INSERT INTO `products`(`productName`, `companyName`, `operatingSystem`, `battery`, `processor`, `description`) VALUES (?,?,?,?,?,?)";
				
		PreparedStatement stat = con.c.prepareStatement(sql);
		
		stat.setString(1, pro.getProductName());		
		stat.setString(2, pro.getCompanyName());
		stat.setString(3, pro.getOperatingSystem());
		stat.setString(4, pro.getBattery());
		stat.setString(5, pro.getProcessor());
		stat.setString(6, pro.getDescription());
		
		stat.executeUpdate();
		
		
	}// End addProduct
	
	
public void updProduct(Product pro) throws ClassNotFoundException, SQLException {
		
		
		Connect con = new Connect();
		
		String sql = "UPDATE `products` SET `productName`=?,`companyName`=?,`operatingSystem`=?,`battery`=?,`processor`=?,`description`=? WHERE `productID`=?";
				
		PreparedStatement stat = con.c.prepareStatement(sql);
		
		stat.setString(1, pro.getProductName());		
		stat.setString(2, pro.getCompanyName());
		stat.setString(3, pro.getOperatingSystem());
		stat.setString(4, pro.getBattery());
		stat.setString(5, pro.getProcessor());
		stat.setString(6, pro.getDescription());
		stat.setInt(7, pro.getProductId());
		
		stat.executeUpdate();
		
		
	}// End addProduct




public void deleteProduct(int proId) throws ClassNotFoundException, SQLException {
	
	Connect con = new Connect();
	
	
	PreparedStatement stat = con.c.prepareStatement("DELETE FROM `products` WHERE `productID` = ?");
	
	stat.setInt(1, proId);
	
	stat.executeUpdate();
	
//    if (res != 0){
//        System.out.println("Deleted successfully on the products table");
//    }
	
	
} 
	
	
	
	
	
	
	
}
