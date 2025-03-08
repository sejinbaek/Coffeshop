package com.shop.cafe.dao;

import java.sql.*;
import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.shop.cafe.dto.Member;
import com.shop.cafe.dto.Product;

@Mapper
public interface MemberDao {
	
	//로그인
	public Member login(Member m) throws Exception;
	
	
	//회원가입
	public void insertMember(Member m) throws Exception;
	
}
