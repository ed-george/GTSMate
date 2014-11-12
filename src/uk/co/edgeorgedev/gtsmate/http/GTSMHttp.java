package uk.co.edgeorgedev.gtsmate.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import uk.co.edgeorgedev.gtsmate.utils.Logger;
import android.content.Context;
import android.os.AsyncTask;

public class GTSMHttp extends AsyncTask<String, Void, String> {

	protected Context ctx;
	protected int async_id;
	public AsyncResponse delegate = null;
	public boolean allowDilog = true, gzip = true;
	protected HttpResponse httpResponse = null;
	protected String url;
	protected long mStartMili;
	protected long mFinishMili;
	protected HttpClient httpClient;
	protected ResetableInputStream mResetableInputStream = null;
	protected Response response;
	public GTSMHttp() {
	}

	public GTSMHttp(Context ctx, int ID, String url) {
		this.ctx = ctx;
		this.async_id = ID;
		this.url = url;
		this.httpClient = new DefaultHttpClient();
		response = Response.UNKNOWN;
	}

	public void useGzip(boolean shouldUse) {
		gzip = shouldUse;
	}

	public HttpClient getHttpClient() {
		return httpClient;
	}

	public void setHttpClient(HttpClient httpClient) {
		this.httpClient = httpClient;
	}

	@Override
	protected String doInBackground(String... params) {
		return "[]";
	}

	@Override
	protected void onPreExecute() {
		mStartMili = System.currentTimeMillis();
	}

	@Override
	protected void onPostExecute(String result) {

		super.onPostExecute(result);

		mFinishMili = System.currentTimeMillis();

		long end = mFinishMili - mStartMili;

		if (result == null) {
			
			if(httpResponse == null){
				// Error occurred
				logError("Error connection error occured");
			}else{
				//
				if(response != Response.NO_CONTENT){

					StatusLine err = httpResponse.getStatusLine();
					if(err != null){
						logError(err.toString());
					}else{
						logError("Error connection error occured");
					}

				}
			}
		} else {
			Logger.d(this.getClass(), result);
		}

		Logger.d(this.getClass(), "Async took " + (float) end / 1000 + "s");

		if(httpResponse != null){
			if(response.isSuccess()){
				delegate.onSuccessResponse(result, response, async_id);
				return;
			}
		}
		delegate.onErrorResponse(result, response, async_id, null);
	}

	protected boolean retrievedResponse(HttpUriRequest request){
		try{

			httpResponse = httpClient.execute(request);
			HttpEntity httpEntity = httpResponse.getEntity();
			
			if (httpResponse != null) {
				response = Response.responseFromCode(httpResponse.getStatusLine().getStatusCode());
				
				if(response == Response.NO_CONTENT)
					return true;
				
			}else{
				response = Response.NETWORK_ERROR;
			}
			
			mResetableInputStream = new ResetableInputStream(httpEntity.getContent());

			return true;
		}catch(Exception e){
			logError(e);
			response = Response.NETWORK_ERROR;
			return false;
		}
	}

	protected String getResponse(){
		try {
			
			if(response == Response.NO_CONTENT)
				return null;
			
			BufferedReader in;

			if (gzip) {

				try{
					in = new BufferedReader(new InputStreamReader(new GZIPInputStream(mResetableInputStream)));
				}catch(Exception e){
					//Assume GZIP is the issue
					Logger.w(getClass(), "GZIP failed - trying to use standard InputStream");

					//FIXME: If GZIP fails, cannot simply use same InputStream
					gzip = false;

					if(mResetableInputStream.isMarkingSupported()){
						mResetableInputStream.close();
						Logger.w(getClass(), "GZIP failed - reset stream");
						in = new BufferedReader(new InputStreamReader(mResetableInputStream));
					}else{
						Logger.e(getClass(), "GZIP failed - Marking not supported");
						mResetableInputStream.forceClose();
						return null;
					}
				}
			} else {
				in = new BufferedReader(new InputStreamReader(mResetableInputStream));
			}

			StringBuilder sb = new StringBuilder();
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				sb.append(inputLine);
			}

			mResetableInputStream.forceClose();
			in.close();

			if(httpClient != null){
				httpClient.getConnectionManager().shutdown();
			}

			return sb.toString();

		}catch(Exception e){
			Logger.e(this.getClass(), "Error retrieving response");
			logError(e);
			return null;
		}
	}

	protected void logError(Exception e) {
		logError(getClass().getCanonicalName());
		e.printStackTrace();	
	}

	private void logError(String error) {
		Logger.e(this.getClass(), error);
		Logger.e(this.getClass(), "URL: " + url);
		Logger.e(this.getClass(), "ASync ID: " + async_id);
	}

}
