/**
 * BopplHttpGet.java
 * Boppl
 * 
 * Created by Ed George on Aug 30, 2013
 * Copyright (c) 2013 Boppl Ltd. All rights reserved. 
 *
 */
package uk.co.edgeorgedev.gtsmate.http;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import uk.co.edgeorgedev.gtsmate.utils.Logger;
import android.content.Context;

public class GTSMHttpGet extends GTSMHttp {

	private HttpGet httpGet;

	public GTSMHttpGet(Context ctx, int ID, String url) {
		super(ctx, ID, url);
		this.httpGet = new HttpGet(url);
	}

	@Override
	protected String doInBackground(String... params) {

		Logger.d(this.getClass(), "URL: " + url);
		// Making HTTP GET request
		try {

			HttpParams httpParameters = new BasicHttpParams();
			// Set the timeout until a connection is established.
			// The default is zero
			int timeoutConnection = 3000;
			HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
			// Set the default socket timeout for waiting for data.
			int timeoutSocket = 10000;
			HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

			SchemeRegistry schReg = new SchemeRegistry();
			schReg.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
			schReg.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
			ClientConnectionManager conMgr = new ThreadSafeClientConnManager(httpParameters, schReg);

			httpClient = new DefaultHttpClient(conMgr, httpParameters);
			
			
			if (gzip){
				addHeader("Accept-Encoding", "gzip");
			}
			
			if(!retrievedResponse(httpGet)){
				return null;
			}

		} catch (Exception e) {
			// Likely to be caused by being offline
			logError(e);
			return null;
		}
		
		return getResponse();
	}
	

	public void addHeader(String key, String value) {
		httpGet.setHeader(key, value);
	}

}
