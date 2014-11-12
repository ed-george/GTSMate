package uk.co.edgeorgedev.gtsmate;

import uk.co.edgeorgedev.gtsmate.gts.GTSTradeList;
import uk.co.edgeorgedev.gtsmate.gts.GTSUser;
import uk.co.edgeorgedev.gtsmate.http.AsyncResponse;
import uk.co.edgeorgedev.gtsmate.http.Response;
import uk.co.edgeorgedev.gtsmate.utils.ApiHelper;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class MainActivity extends Activity implements AsyncResponse {

	TextView textView;
	GTSUser user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textView = (TextView) findViewById(R.id.textView);

		user = new GTSUser("G-446-3267-U");

		ApiHelper.getSecretCredentials(this, user.getUser_id()).execute();

	}

	@Override
	public void onSuccessResponse(String result, Response response, int id) {

		switch(id){
		case ApiHelper.SECRET_CRED:

			if(user.getSecretCredentials(result)){
				ApiHelper.getTrade(this, user).execute();
			}
			break;

		case ApiHelper.GET_TRADES:
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			JsonParser jp = new JsonParser();
			JsonElement je = jp.parse(result);
			String prettyJsonString = gson.toJson(je);

			GTSTradeList list = gson.fromJson(result, GTSTradeList.class);
			if(!list.isError()){
				textView.setText(prettyJsonString);
			}else{
				textView.setText(list.getError().toString());
			}
			break;
		}

	}

	@Override
	public void onErrorResponse(String body, Response response, int id, Throwable e) {


	}

}
