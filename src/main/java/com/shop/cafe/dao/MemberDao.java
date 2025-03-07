package com.shop.cafe.dao;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.shop.cafe.dto.Member;
import com.shop.cafe.dto.Product;

@Repository
public class MemberDao {
	
	@Value("${spring.datasource.driver-class-name}") //application.properties에 있는 값을 가져오기
	private String DB_DRIVER;
	
	@Value("${spring.datasource.url}")
	private String DB_URL;
	
	@Value("${spring.datasource.username}")
	private String DB_USER;
	
	@Value("${spring.datasource.password}")
	private String DB_PW;
	
	
	//JDBC 6단계
	public void insertMember(Member m) throws Exception {
		System.out.println("MemberDao insertMember() 호출됨");
		Class.forName(DB_DRIVER);
		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PW); //필수적으로 고쳐야 하는 부분
		PreparedStatement stmt = con.prepareStatement("insert into member(email, pwd, nickname) values(?,?,?)");
		stmt.setString(1, m.getEmail());
		stmt.setString(2, m.getPwd());
		stmt.setString(3, m.getNickname());
		
		int i = stmt.executeUpdate();
		
		System.out.println(i + "행이 insert 되었습니다");
	
	}
	
//	public static void main(String[] args) throws Exception { //오타 확인(java app으로 run)
//		System.out.println(getAllProducts());
//	}
	
}
