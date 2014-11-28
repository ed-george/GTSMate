/**
 * SettingsActivity.java
 * GTSMate
 *
 * Created by Ed George on 27 Nov 2014
 *
 */
package uk.co.edgeorgedev.gtsmate;

import android.app.Activity;
import android.os.Bundle;

/**
 * @author edgeorge
 *
 */
public class SettingsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }
}
