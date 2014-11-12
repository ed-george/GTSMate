package uk.co.edgeorgedev.gtsmate.utils;

import android.util.Log;

public class Logger {

	public static final String TAG = "GTSMate";

	public static void e(Class<?> clazz, String msg){	
		//Always Show Error

		if(clazz == null){
			Log.e(TAG, msg);	
			return;
		}

		Log.e(clazz.getName(), msg);
	}

	public static void d(Class<?> clazz, String msg){	

		if(clazz == null){
			Log.d(TAG, msg);	
			return;
		}
		Log.d(clazz.getName(), msg);

	}

	public static void v(Class<?> clazz, String msg){	
		if(clazz == null){
			Log.v(TAG, msg);	
			return;
		}

		Log.v(clazz.getName(), msg);	
	}

	public static void i(Class<?> clazz, String msg){	

			if(clazz == null){
				Log.i(TAG, msg);	
				return;
			}
			Log.i(clazz.getName(), msg);
	}

	public static void w(Class<?> clazz, String msg) {

		if(clazz == null){
			Log.w(TAG, msg);	
			return;
		}

		Log.w(clazz.getName(), msg);

	}
	

}
