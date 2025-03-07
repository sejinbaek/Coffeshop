package com.shop.cafe.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.cafe.dto.Product;
import com.shop.cafe.service.ProductService;

@RestController
@CrossOrigin("http://192.168.144.1:5500/")
public class ProductController {
	
	@Autowired
	ProductService productService;
	//극단적으로 성능을 향상시키는 방법
	Map<String, Object> storage = new HashMap();
	
	@GetMapping("getAllProducts")
	public List<Product> getAllProducts() {
		try {
			Object o = storage.get("firstPageProducts");
			if(o == null) { //null이면 DB에 갔다오게 하기
				List<Product> list = productService.getAllProducts();
				storage.put("firstPageProducts", list);
				return list;
			} 
			return (List<Product>) o;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
