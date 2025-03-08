package com.shop.cafe.dao;

import java.sql.*;
import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.shop.cafe.dto.Product;

@Mapper
public interface ProductDao {
	
	
	//JDBC 6단계
	public List<Product> getAllProducts() throws Exception;
	
//	public static void main(String[] args) throws Exception { //오타 확인(java app으로 run)
//		System.out.println(getAllProducts());
//	}
	
}
