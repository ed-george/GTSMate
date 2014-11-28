/**
 * SettingsActivity.java
 * GTSMate
 *
 * Created by Ed George on 27 Nov 2014
 *
 */
package uk.co.edgeorgedev.gtsmate;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * @author edgeorge
 *
 */
public class SettingsFragment extends PreferenceFragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		addPreferencesFromResource(R.xml.preferences);
		
	}
}
