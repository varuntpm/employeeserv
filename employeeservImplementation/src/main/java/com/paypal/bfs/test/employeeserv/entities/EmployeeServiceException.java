package com.paypal.bfs.test.employeeserv.entities;

import java.util.Map;


public class EmployeeServiceException {
	private String message;

	private Map<String, String> errorInfo;

	public EmployeeServiceException(String message, Map<String, String> errorInfo) {
		super();
		this.message = message;
		this.errorInfo = errorInfo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, String> getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(Map<String, String> errorInfo) {
		this.errorInfo = errorInfo;
	}

}
