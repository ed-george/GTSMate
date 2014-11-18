package uk.co.edgeorgedev.gtsmate.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources.NotFoundException;

public class FileUtils {

	public static String loadFileFromAssets(Context ctx, String fileName) throws NotFoundException, SQLException {

		AssetManager assetManager = ctx.getResources().getAssets();
		InputStream inputStream = null;

		try {
			inputStream = assetManager.open(fileName);

			StringBuilder buf = new StringBuilder();

			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			String str;

			while ((str = in.readLine()) != null) {
				buf.append(str);
			}

			in.close();

			return buf.toString();

		} catch (Exception e) {
			Logger.e(FileUtils.class, "An error occured processing file " + fileName);
			e.printStackTrace();
			return null;

		}
	}


}
