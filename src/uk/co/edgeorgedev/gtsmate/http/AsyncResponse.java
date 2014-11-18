/**
 * AsyncResponse.java
 * Boppl
 * 
 * Created by Ed George on Aug 30, 2013
 * Copyright (c) 2013 Boppl Ltd. All rights reserved. 
 *
 */
package uk.co.edgeorgedev.gtsmate.http;

import org.apache.http.client.CookieStore;

/**
 * @author edgeorge
 *
 */

public interface AsyncResponse {	
	void onSuccessResponse(String result, Response response, int id, CookieStore cookies);
	void onErrorResponse(String body, Response response, int id, Throwable e);
}
