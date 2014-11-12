/**
 * AsyncResponse.java
 * Boppl
 * 
 * Created by Ed George on Aug 30, 2013
 * Copyright (c) 2013 Boppl Ltd. All rights reserved. 
 *
 */
package uk.co.edgeorgedev.gtsmate.http;

/**
 * @author edgeorge
 *
 */

public interface AsyncResponse {	
	void onSuccessResponse(String result, Response response, int id);
	void onErrorResponse(String body, Response response, int id, Throwable e);
}
