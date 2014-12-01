package uk.co.edgeorgedev.gtsmate;

import uk.co.edgeorgedev.gtsmate.gts.GTSTradeList;
import uk.co.edgeorgedev.gtsmate.ui.TradeAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TradeActivity extends BaseActivity {

	private DrawerLayout mDrawerLayout;
	private RecyclerView mRecyclerView;
	private TradeAdapter mAdapter;
	private GTSTradeList list;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setActionBarIcon(R.drawable.ic_ab_drawer);
		
		Gson gson = new GsonBuilder().create();
		String result = getIntent().getStringExtra("list");
		list = gson.fromJson(result, GTSTradeList.class);
		
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, Gravity.START);
		
		mRecyclerView = (RecyclerView) findViewById(R.id.list);
		mRecyclerView.setHasFixedSize(true);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
	
		mAdapter = new TradeAdapter(this, list);
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

	
	@Override
	protected OnItemClickListener getMenuAdapter() {
		return new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				switch(position){
				 default:
					 startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
					 mDrawerLayout.closeDrawer(Gravity.START);
					 break;
				}
			}
		};
	}


	@Override
	protected String[] getMenuLabels() {
		return getResources().getStringArray(R.array.menu_array);
	}


	@Override
	protected Integer[] getMenuIcons() {
		return new Integer[]{R.drawable.ic_cog_white, R.drawable.ic_history_white, R.drawable.ic_account_multiple_white, R.drawable.ic_twitter_white, R.drawable.ic_heart_white};
	}

}
