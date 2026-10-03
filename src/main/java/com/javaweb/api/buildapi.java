package com.javaweb.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.ErrorResonse;
import com.javaweb.model.buildingbean;
import com.javaweb.model.storebean;
import com.javaweb.service.Buildingservice;

import customexeption.FieldRequeiredException;
@RestController
public class buildapi {
	@Autowired
	private Buildingservice buildingservice;
	 @GetMapping(value = "/api/building")
	    public List<buildingbean> getBuildingbeans(@RequestParam(value ="name",required = false)String name,
	    		@RequestParam(value="districtid",required = false)Integer districtid) {
	    	List<buildingbean> result = buildingservice.findAll(name,districtid);
	    	return null;
//		 	try {
//		 		validate(building);
//		 	}catch (FieldRequeiredException e) {
//				// TODO: handle exception
//		 		ErrorResonse errorResonse = new ErrorResonse();
//		 		errorResonse.setError(e.getMessage());
//		 		List<String> detaiList = new ArrayList<>();
//		 		detaiList.add("lỗi số nguyên");
//		 		errorResonse.setErrorStrings(detaiList);
//		 		
//			}
//		 	return null;
	    }
		
	 @PostMapping(value = "/api/building")
	 public Object getbuilding2(@RequestBody buildingbean bean) {
		 validate(bean);
		 return null;
	 }
	 public  void validate(buildingbean buildingDTO) {
		 if(buildingDTO.getName() == null || buildingDTO.getName().equals("") || buildingDTO.getNumberofbasement() == null) {
			 throw new FieldRequeiredException("Name or Number is null");
		 }
		
	 }
	 @DeleteMapping(value = "/api/building/{id}")
	 public void deletebuilding(@PathVariable Integer id) {
		 System.out.print("da xoa toa nha");
	 }
	 
	 @GetMapping(value="/api/toy")
	 public List<storebean> getStorebean(@RequestParam(value = "toy",required = false)String toy,
			 @RequestParam(value = "sold",required = false )Integer sold,
			 @RequestParam(value = "ward",required = false)String ward) {
		 List<storebean> liststorebean = new ArrayList<>();
		 
		 storebean storebean1=new storebean();
		 storebean1.setToy("robot");
		 storebean1.setSold(100);
		 storebean1.setWard("hanoi");
		 storebean storebean2 = new storebean();
		 storebean2.setToy("gundam");
		 storebean2.setSold(200);
		 storebean2.setWard("sontay");
		 liststorebean.add(storebean2);
		 liststorebean.add(storebean1);
		 return liststorebean;
	 }
}