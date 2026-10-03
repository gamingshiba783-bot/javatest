package com.javaweb.service;

import java.util.List;

import com.javaweb.model.buildingbean;
import com.javaweb.repository.entity.Buildingentity;

public interface Buildingservice {
	List<buildingbean> findAll(String name,Integer districtid);
}
