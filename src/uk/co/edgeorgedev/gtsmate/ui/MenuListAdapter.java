/**
 * MenuListAdapter.java
 * GTSMate
 *
 * Created by Ed George on 26 Nov 2014
 *
 */
package uk.co.edgeorgedev.gtsmate.ui;

import uk.co.edgeorgedev.gtsmate.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author edgeorge
 *
 */
public class MenuListAdapter extends ArrayAdapter<String>{

	private Context context;
	private int layout;
	private String[] labels;
	private Integer[] images;
	
	public MenuListAdapter(Context context, int layout, String[] labels, Integer[] images) {
		super(context, layout, labels);
		this.context = context;
		this.layout = layout;
		this.labels = labels;
		this.images = images;
	}
	

	/* (non-Javadoc)
	 * @see android.widget.ArrayAdapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		View view = inflater.inflate(layout, null, true);
		TextView txtTitle = (TextView) view.findViewById(R.id.list_label);
		ImageView imageView = (ImageView) view.findViewById(R.id.list_image);
		txtTitle.setText(labels[position]);
		imageView.setImageResource(images[position]);
		return view;
	}
	
}
