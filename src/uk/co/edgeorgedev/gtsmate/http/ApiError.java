/**
 * Error.java
 * Boppl
 * 
 * Created by Ed George on Aug 19, 2013
 * Copyright (c) 2013 Boppl Ltd. All rights reserved. 
 *
 */
package uk.co.edgeorgedev.gtsmate.http;

/**
 * @author edgeorge
 *
 */
public class ApiError {

	private int error_code;
	private String error_desc;
	
	public int getError_code() {
		return error_code;
	}
	public void setError_code(int error_code) {
		this.error_code = error_code;
	}
	public String getError_desc() {
		return error_desc;
	}
	public void setError_desc(String error_desc) {
		this.error_desc = error_desc;
	}
	
}
