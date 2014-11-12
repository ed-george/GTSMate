/**
 * BopplHttpPost.java
 * Boppl
 * 
 * Created by Ed George on Sep 24, 2013
 * Copyright (c) 2013 Boppl Ltd. All rights reserved. 
 *
 */
package uk.co.edgeorgedev.gtsmate.http;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;

/**
 * @author edgeorge
 * 
 */
public class GTSMHttpPost extends GTSMHttp {


	private HttpPost httppost;
	private List<NameValuePair> formEncode;

	public GTSMHttpPost(Context ctx, int ID, String url) {
		super(ctx, ID, url);
		httppost = new HttpPost(url);
		gzip = false;
		formEncode = new ArrayList<NameValuePair>();
	}


	@Override
	protected String doInBackground(String... params) {

		try {

			if (params.length > 0) {
				httppost.setEntity(new StringEntity(params[0]));
			}else{
				httppost.setEntity(new UrlEncodedFormEntity(formEncode));
			}

			if(!retrievedResponse(httppost)){
				return null;
			}

			return getResponse();

		} catch (Exception e) {
			logError(e);
			return null;
		}

	}

	// End of doInBackround()

	public void addHeader(String key, String value) {
		httppost.setHeader(key, value);
	}
	
	public void addUrlEncodedFormEntity(String key, String value){
		formEncode.add(new BasicNameValuePair(key, value));
	}

	
}
