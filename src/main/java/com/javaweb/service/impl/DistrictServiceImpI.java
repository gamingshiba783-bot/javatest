package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.message.ExitMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.model.Districtbean;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.service.Districtservice;
@Service
public class DistrictServiceImpI implements Districtservice {
	@Autowired
	private DistrictRepository districtRepository;
	@Override
	public List<Districtbean> findAll() {
		List<DistrictEntity> districtEntitys = districtRepository.findAll();
		List<Districtbean> result=new ArrayList<Districtbean>();
		for(DistrictEntity item: districtEntitys) {
			Districtbean districtbean = new Districtbean();
			districtbean.setCode(item.getCode());
			districtbean.setDistrictString(item.getName()+"-"+item.getCode());
			result.add(districtbean);
		}
		return result;
	}

}
