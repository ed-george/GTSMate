package uk.co.edgeorgedev.gtsmate;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

public class TradeActivity extends BaseActivity {

	private DrawerLayout drawer;
	private RecyclerView mRecylclerView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setActionBarIcon(R.drawable.ic_ab_drawer);
		drawer = (DrawerLayout) findViewById(R.id.drawer);
		drawer.setDrawerShadow(R.drawable.drawer_shadow, Gravity.START);
		mRecylclerView = (RecyclerView) findViewById(R.id.list);
		mRecylclerView.setLayoutManager(new LinearLayoutManager(this));
	}

	@Override
	protected int getLayoutResource() {
		return R.layout.trade_activity;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			drawer.openDrawer(Gravity.START);
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

}
