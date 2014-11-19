package uk.co.edgeorgedev.gtsmate;

import uk.co.edgeorgedev.gtsmate.ui.TradeAdapter;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

public class TradeActivity extends BaseActivity {

	private DrawerLayout mDrawerLayout;
	private RecyclerView mRecyclerView;
	private TradeAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setActionBarIcon(R.drawable.ic_ab_drawer);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, Gravity.START);
		
		mRecyclerView = (RecyclerView) findViewById(R.id.list);
		mRecyclerView.setHasFixedSize(true);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
	
		mAdapter = new TradeAdapter(new String[]{"Ed", "George", "Derp","Ed", "George", "Derp"});
        mRecyclerView.setAdapter(mAdapter);
		
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
			mDrawerLayout.openDrawer(Gravity.START);
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

}
