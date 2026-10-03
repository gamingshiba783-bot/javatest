package com.javaweb.model;

import java.util.ArrayList;
import java.util.List;

public class ErrorResonse {
	private String error;
	private List<String> detail = new ArrayList<String>();
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public List<String> getErrorStrings() {
		return detail;
	}
	public void setErrorStrings(List<String> errorStrings) {
		this.detail = errorStrings;
	}
	
}
