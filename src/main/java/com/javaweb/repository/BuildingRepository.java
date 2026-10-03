package com.javaweb.repository;

import java.util.List;

import com.javaweb.repository.entity.Buildingentity;

public interface BuildingRepository {
	List<Buildingentity> findAll(String name,Integer districtid);
}
