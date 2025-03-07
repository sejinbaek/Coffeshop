package com.shop.cafe.dao;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.shop.cafe.dto.Product;

@Repository
public class ProductDao {
	
	@Value("${spring.datasource.driver-class-name}") //application.properties에 있는 값을 가져오기
	private String DB_DRIVER;
	
	@Value("${spring.datasource.url}")
	private String DB_URL;
	
	@Value("${spring.datasource.username}")
	private String DB_USER;
	
	@Value("${spring.datasource.password}")
	private String DB_PW;
	
	
	//JDBC 6단계
	public List<Product> getAllProducts() throws Exception {
		System.out.println("ProductDao getAllProducts() 호출됨");
		Class.forName(DB_DRIVER);
		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
		PreparedStatement stmt = con.prepareStatement("select * from product limit 6"); //한 페이지 분량만 가져오기
		ResultSet rs = stmt.executeQuery();
		
		List<Product> list = new ArrayList<>();
		
		while(rs.next()) {
			int prodcode = rs.getInt("prodcode");
			String prodname = rs.getString("prodname");
			String pimg = rs.getString("pimg");
			int price = rs.getInt("price");
			list.add(new Product(prodname, pimg, prodcode, price));
		}
		return list;
	
	}
	
//	public static void main(String[] args) throws Exception { //오타 확인(java app으로 run)
//		System.out.println(getAllProducts());
//	}
	
}
