package uk.co.edgeorgedev.gtsmate.utils;

import uk.co.edgeorgedev.gtsmate.gts.GTSUser;
import uk.co.edgeorgedev.gtsmate.http.AsyncResponse;
import uk.co.edgeorgedev.gtsmate.http.GTSMHttpGet;
import uk.co.edgeorgedev.gtsmate.http.GTSMHttpPost;
import android.content.Context;

public class ApiHelper {


	public static final int SECRET_CRED = 42;
	public static final int GET_TRADES = 69;

	public static GTSMHttpGet getSecretCredentials(Context ctx, String user_id){

		GTSMHttpGet getSecredCreds = new GTSMHttpGet(ctx, SECRET_CRED, "http://3ds.pokemon-gl.com/user/"+user_id+"/gts/");
		getSecredCreds.gzip = false;
		getSecredCreds.delegate = (AsyncResponse) ctx;
		return getSecredCreds;

	}

	public static GTSMHttpPost getTrade(Context ctx, GTSUser user) {
		GTSMHttpPost getTrades = new GTSMHttpPost(ctx, GET_TRADES, "http://3ds.pokemon-gl.com/frontendApi/mypage/getGtsTradeList");
		getTrades.gzip = false;
		getTrades.addHeader("Pragma","no-cache");
		getTrades.addHeader("Origin","http://3ds.pokemon-gl.com");
		getTrades.addHeader("Accept-Encoding","gzip,deflate");
		getTrades.addHeader("Accept-Language","en-US,en;q=0.8");
		getTrades.addHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
		getTrades.addHeader("Accept","application/json, text/javascript, */*; q=0.01");
		getTrades.addHeader("Host","3ds.pokemon-gl.com");
		getTrades.addHeader("Cache-Control","no-cache");
		getTrades.addHeader("X-Requested-With","XMLHttpRequest");
		getTrades.addHeader("Connection","keep-alive");
		getTrades.addHeader("Referer","http://3ds.pokemon-gl.com/user/"+user.getUser_id()+"/gts/");
		getTrades.addHeader("Cookie", "__ulfpc=201409080034328164; region=2; language_id=2; site=2; JSESSIONID=E342771495B3443105492036812617E1; AWSELB=99C3FF770EA3504C46F25D799674203D12E259AC7A1035A303B68DCF1E2854127DF3608B9795D1BA69576F39CEAD6A41F4053F7B200CBC6343232C4A3A4C82686514AF8074D7C69113833A2439FB0C57F71320BF2F; __utmt=1; __utma=234147713.376062857.1410132870.1415777023.1415788715.8; __utmb=234147713.1.10.1415788715; __utmc=234147713; __utmz=234147713.1414056414.4.4.utmcsr=pokemon.co.jp|utmccn=(referral)|utmcmd=referral|utmcct=/redirect/index.php/2545/; NO_MEMBER_DATA=%7B%22language_id%22%3A2%2C%22site%22%3A2%2C%22region%22%3A2%7D");
		
		getTrades.addUrlEncodedFormEntity("languageId", "2");
		getTrades.addUrlEncodedFormEntity("memberSavedataIdCode", user.getUser_id());
		getTrades.addUrlEncodedFormEntity("accountId", user.getAccount_id());
		getTrades.addUrlEncodedFormEntity("savedataId", user.getSavedata_id());
		//getTrades.addUrlEncodedFormEntity("myPageTab", "gts");
		getTrades.addUrlEncodedFormEntity("timestamp", Long.toString(System.currentTimeMillis()));
		//getTrades.addUrlEncodedFormEntity("page", "1");
		getTrades.addUrlEncodedFormEntity("count", "1");
		
		getTrades.delegate = (AsyncResponse) ctx;
		return getTrades;
	}
}
