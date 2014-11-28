package uk.co.edgeorgedev.gtsmate;


import uk.co.edgeorgedev.gtsmate.ui.MenuListAdapter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public abstract class BaseActivity extends ActionBarActivity {

	private Toolbar toolbar;
	private ListView menu;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutResource());
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		if (toolbar != null) {
			setSupportActionBar(toolbar);
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		}

		menu = (ListView) findViewById(R.id.menu);
		if(menu != null){
			menu.setAdapter(new MenuListAdapter(getApplicationContext(), R.layout.list_layout, getMenuLabels(), getMenuIcons()));
			menu.setOnItemClickListener(getMenuAdapter());
		}
	}

	
	protected abstract OnItemClickListener getMenuAdapter();
	protected abstract int getLayoutResource();
	protected abstract String[] getMenuLabels();
	protected abstract Integer[] getMenuIcons();
	
	protected void setActionBarIcon(int iconRes) {
		toolbar.setNavigationIcon(iconRes);
	}
}