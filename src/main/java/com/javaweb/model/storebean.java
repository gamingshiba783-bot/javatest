package com.javaweb.model;

import org.springframework.web.filter.ForwardedHeaderFilter;

public class storebean {
	private String toy;
	private Integer sold;
	private String ward;
	public String getToy() {
		return toy;
	}
	public void setToy(String toy) {
		this.toy = toy;
	}
	public Integer getSold() {
		return sold;
	}
	public void setSold(Integer sold) {
		this.sold = sold;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	
	
}
