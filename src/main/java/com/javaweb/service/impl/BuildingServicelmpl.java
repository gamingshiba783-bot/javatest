package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.buildingbean;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.Buildingentity;
import com.javaweb.service.Buildingservice;

@Service
public class BuildingServicelmpl implements Buildingservice{
	@Autowired
	private BuildingRepository  buildingRepository;
	@Override
	public List<buildingbean> findAll(String name,Integer districtid) {
		List<Buildingentity> buildingentitys = buildingRepository.findAll(name,districtid);
		List<buildingbean> result=new ArrayList<buildingbean>();
		for(Buildingentity item : buildingentitys) {
			buildingbean building=new buildingbean();
			building.setName(item.getName());
			building.setAddress(item.getStreet()+","+item.getWard());
			building.setNumberofbasement(item.getNumberofbasement());
			result.add(building);
		}
		return result;
	}

}
