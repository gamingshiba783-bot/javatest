package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.entity.DistrictEntity;

@Repository

public class DistrictRepositoryImpl implements DistrictRepository {
	static final String DB_URL = "jdbc:mysql://localhost:3306/realestate";
	static final String USER = "root";
	static final String PASS = "123456";
	@Override
	public List<DistrictEntity> findAll(){
		String sql = "SELECT * FROM District";
		List<DistrictEntity> result = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);){
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);  		
    		while (rs.next()) {
    			DistrictEntity districtEntity = new DistrictEntity();
    			districtEntity.setCode(rs.getString("code"));;
    			districtEntity.setName(rs.getString("name"));
    			result.add(districtEntity);
    		}
    		
    	}catch (SQLException e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
return result;
	}

}
