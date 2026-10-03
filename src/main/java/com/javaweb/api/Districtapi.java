package com.javaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.Districtbean;
import com.javaweb.service.Districtservice;

@RestController
public class Districtapi {
	@Autowired
	private  Districtservice districtservice;
	@GetMapping(value = "/api/district")
	public List<Districtbean> getdistrictbean(){
		List<Districtbean> result = districtservice.findAll();
		return result;
	}
}
