/**
You make  * BopplHttpPut.java
 * Boppl
 * 
 * Created by Ed George on Oct 9, 2013
 * Copyright (c) 2013 Boppl Ltd. All rights reserved. 
 *
 */
package uk.co.edgeorgedev.gtsmate.http;

import java.util.Locale;

import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

import android.content.Context;

/**
 * @author edgeorge
 * 
 */
public class GTSMHttpPut extends GTSMHttp {

	private HttpPut httpput;

	public GTSMHttpPut(Context ctx, int ID, String url) {
		super(ctx, ID, url);
		httpput = new HttpPut(url);
		gzip = false;
	}


	@Override
	protected String doInBackground(String... params) {

		try{
			if (params.length > 0) {

				// JSON
				addGenericJsonHeaders();
				httpput.setEntity(new StringEntity(params[0]));

			}

			if(!retrievedResponse(httpput)){
				return null;
			}

			return getResponse();
			
		}catch(Exception e){
			logError(e);
			return null;
		}
	}

	// End of doInBackround()

	public void addHeader(String key, String value) {
		httpput.setHeader(key, value);
	}

	public void addGenericJsonHeaders() {
		httpput.setHeader("Accept", "application/json");
		httpput.setHeader("Accept-Charset", "utf-8");
		httpput.setHeader("Content-Type", "application/json");
		httpput.addHeader("Accept-Language", Locale.getDefault().getLanguage());
	}


}
