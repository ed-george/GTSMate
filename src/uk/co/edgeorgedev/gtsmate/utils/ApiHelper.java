package uk.co.edgeorgedev.gtsmate.utils;

import java.util.List;

import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;

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

	public static GTSMHttpPost getTrade(Context ctx, GTSUser user, CookieStore cookies) {
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
		
		if(cookies != null){
//			
//			StringBuilder cookieBuilder = new StringBuilder();
//			cookieBuilder.append("region=2; language_id=2; site=2; __utmt=1; __ulfpc=201409080034328164; NO_MEMBER_DATA=%7B%22language_id%22%3A2%2C%22site%22%3A2%2C%22region%22%3A2%7D; __utmz=234147713.1414056414.4.4.utmcsr=pokemon.co.jp|utmccn=(referral)|utmcmd=referral|utmcct=/redirect/index.php/2545/; ");
//			for(Cookie cookie:cookies.getCookies()){
//				cookieBuilder.append(cookie.getName()+"="+cookie.getValue()+"; ");
//			}
//			String cookie_ = cookieBuilder.toString();
//			getTrades.addHeader("Cookie", cookie_.substring(0, cookie_.length() - 2));
//			Logger.w(ApiHelper.class,  cookie_.substring(0, cookie_.length() - 2));
		List<Cookie> cookie_list = cookies.getCookies();
		for(Cookie c : cookie_list){
			Logger.w(ApiHelper.class, formatCookie(c));
		}
		//getTrades.addHeader("Cookie", "__ulfpc=201409080034328164; region=2; language_id=2; site=2; __utmt=1; NO_MEMBER_DATA=%7B%22language_id%22%3A2%2C%22site%22%3A2%2C%22region%22%3A2%7D; "+ formatCookie(cookie_list.get(0)) +" PGLLOGINTIME="+Long.toString(System.currentTimeMillis())+"; "+ formatCookie(cookie_list.get(1)) +" __utma=234147713.376062857.1410132870.1415788715.1415822040.9; __utmb=234147713.7.10.1415822040; __utmc=234147713; __utmz=234147713.1414056414.4.4.utmcsr=pokemon.co.jp|utmccn=(referral)|utmcmd=referral|utmcct=/redirect/index.php/2545/");
		
		}
//		
		getTrades.addHeader("Cookie", "__ulfpc=201409080034328164; region=2; language_id=2; site=2; __utmt=1; NO_MEMBER_DATA=%7B%22language_id%22%3A2%2C%22site%22%3A2%2C%22region%22%3A2%7D; JSESSIONID=587EB44C059045C587CD42DE3DD21786; PGLLOGINTIME=1415822063687; AWSELB=99C3FF770EA3504C46F25D799674203D12E259AC7AB2BED61E97DC4D9DA2487A6904C8EA4371EB858D3DAF5763CBD19D604155CE5245A267DB7E496BEA70327F1D05B86B1023FF697977A00E295CBB8437E703A8CE; __utma=234147713.376062857.1410132870.1415788715.1415822040.9; __utmb=234147713.7.10.1415822040; __utmc=234147713; __utmz=234147713.1414056414.4.4.utmcsr=pokemon.co.jp|utmccn=(referral)|utmcmd=referral|utmcct=/redirect/index.php/2545/");
		
		getTrades.addUrlEncodedFormEntity("languageId", "2");
		getTrades.addUrlEncodedFormEntity("memberSavedataIdCode", user.getUser_id());
		getTrades.addUrlEncodedFormEntity("accountId", user.getAccount_id());
		getTrades.addUrlEncodedFormEntity("savedataId", user.getSavedata_id());
		getTrades.addUrlEncodedFormEntity("myPageTab", "gts");
		getTrades.addUrlEncodedFormEntity("timestamp", Long.toString(System.currentTimeMillis()));
		getTrades.addUrlEncodedFormEntity("page", "1");
		getTrades.addUrlEncodedFormEntity("count", "1");
		
		getTrades.delegate = (AsyncResponse) ctx;
		return getTrades;
	}
	
	
	public static String formatCookie(Cookie cookie){
		return cookie.getName() + "=" + cookie.getValue() + ";";
	}
	
}
