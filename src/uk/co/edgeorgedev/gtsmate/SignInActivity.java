package uk.co.edgeorgedev.gtsmate;

import java.sql.SQLException;

import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;

import uk.co.edgeorgedev.gtsmate.gts.GTSTradeList;
import uk.co.edgeorgedev.gtsmate.gts.GTSUser;
import uk.co.edgeorgedev.gtsmate.http.AsyncResponse;
import uk.co.edgeorgedev.gtsmate.http.Response;
import uk.co.edgeorgedev.gtsmate.utils.ApiHelper;
import uk.co.edgeorgedev.gtsmate.utils.FileUtils;
import uk.co.edgeorgedev.gtsmate.utils.Logger;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.flavienlaurent.notboringactionbar.KenBurnsSupportView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SignInActivity extends Activity implements AsyncResponse {

	private GTSUser user;
	private KenBurnsSupportView mBackground;
	private Button mSignIn;
	private EditText mUserIdEditTxt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			super.setTheme(android.R.style.Theme_Holo_NoActionBar_TranslucentDecor);
		}

		setContentView(R.layout.sign_in_screen);
		
		mUserIdEditTxt = (EditText) findViewById(R.id.sign_in_username);

		mSignIn = (Button) findViewById(R.id.log_in_submit_button);
		mSignIn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String code = mUserIdEditTxt.getText().toString().trim();

				if(GTSUser.isValidGTSID(code)){
					showLoader();
					user = new GTSUser(code);
					ApiHelper.getSecretCredentials(SignInActivity.this, user.getUser_id()).execute();
				}else{
					Toast.makeText(getApplicationContext(), R.string.invalid_gl_id, Toast.LENGTH_SHORT).show();
				}

			}
		});

		mBackground = (KenBurnsSupportView) findViewById(R.id.sign_in_bg);
		mBackground.setResourceIds(R.drawable.flashfire_header, R.drawable.flashfire_header2);	

	}

	private void showLoader() {
		mUserIdEditTxt.setEnabled(false);
		mSignIn.setVisibility(View.GONE);
		findViewById(R.id.sign_in_spinner).setVisibility(View.VISIBLE);
	}

	private void hideLoader() {
		mUserIdEditTxt.setEnabled(true);
		mSignIn.setVisibility(View.VISIBLE);
		findViewById(R.id.sign_in_spinner).setVisibility(View.GONE);
	}

	@Override
	public void onSuccessResponse(String result, Response response, int id, CookieStore cookies) {

		switch(id){
		case ApiHelper.SECRET_CRED:
			
			Logger.d(getClass(), "SECRET_CRED");
			
			if(user.getSecretCredentials(result)){
				ApiHelper.getTrade(this, user, cookies).execute();
			}else{
				hideLoader();
				Toast.makeText(getApplicationContext(), R.string.gl_error, Toast.LENGTH_LONG).show();
			}


			break;

		case ApiHelper.GET_TRADES:
			
			Logger.d(getClass(), "GET_TRADES");
			
			//TODO: REMOVE--------------------
			
			if(cookies != null){
				for(Cookie c : cookies.getCookies()){
					Logger.w(getClass(), ApiHelper.formatCookie(c));
				}
			}
			
			try {
				result = FileUtils.loadFileFromAssets(getApplicationContext(), "test.json");
			} catch (NotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			//--------------------------------
			
			Gson gson = new GsonBuilder().create();	

			GTSTradeList list = gson.fromJson(result, GTSTradeList.class);
			if(!list.isError()){
				Intent intent = new Intent(SignInActivity.this, TradeActivity.class);
				intent.putExtra("list", result);
				startActivity(intent);
				overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
			}else{
				if(list.getError() != null){
					Toast.makeText(getApplicationContext(), list.getError().getMessage(), Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(getApplicationContext(), R.string.gl_error, Toast.LENGTH_SHORT).show();
				}
			}
			
			hideLoader();
			
			break;
		}

	}

	@Override
	public void onErrorResponse(String body, Response response, int id, Throwable e) {
		switch(id){	
		default:
			Logger.e(getClass(), response.toString());
			switch (response){
			case NETWORK_ERROR:
				Toast.makeText(getApplicationContext(), R.string.con_error, Toast.LENGTH_LONG).show();
				break;
			default:
				Toast.makeText(getApplicationContext(), R.string.gl_error, Toast.LENGTH_LONG).show();
				break;
			}
			hideLoader();
		}	
	}

}
