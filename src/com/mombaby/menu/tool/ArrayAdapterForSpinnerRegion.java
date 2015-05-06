package com.mombaby.menu.tool;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.mombaby.MombabyPod.R;

public class ArrayAdapterForSpinnerRegion extends ArrayAdapter<CharSequence> {
	
	private LayoutInflater mLayInf;
	private Spinner mSpinner;
	public ArrayList<String> activityList = new ArrayList<String>();
	private int mViewResource;
	String TAG = "joey";

	public ArrayAdapterForSpinnerRegion(Context context, 
			int textViewResourceId, ArrayList<CharSequence> acList, 
			Spinner spinner) {
		super(context, textViewResourceId, acList);
		// TODO Auto-generated constructor stub
		mLayInf = (LayoutInflater) context
    			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mViewResource=textViewResourceId;
		//activityList=acList;
		mSpinner = spinner;
	}
	
	
//	@Override
//	public int getCount() {
//		// TODO Auto-generated method stub
//		
//		return activityList.size();
//	}
//
//	@Override
//	public String getItem(int position) {
//		// TODO Auto-generated method stub
//		
//		return activityList.get(position);
//	}
//
//	@Override
//	public long getItemId(int position) {
//		position = mSpinner.getSelectedItemPosition();
//		return position;
//	}
	
//	@Override
//	public View getView(int position, View convertView, ViewGroup parent) {
//		convertView=mLayInf.inflate(mViewResource, null);		
//		TextView tv=(TextView) convertView.findViewById(R.id.txtSpn);
//		tv.setText(activityList.get(position));
//		return convertView;
//	}
	
	
	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v = mLayInf.inflate(R.layout.spinner_dropdown_item, parent, false);
		TextView txt = (TextView) v.findViewById(R.id.txtSpnDropDown);
		txt.setText(getItem(position).toString());
		
//		convertView=mLayInf.inflate(mViewResource, null);		
//		TextView tv=(TextView) convertView.findViewById(R.id.txtSpn);
//		tv.setText(activityList.get(position));
		
		if (position == mSpinner.getSelectedItemPosition())
			v.setBackgroundColor(Color.RED);

		Log.v(TAG,"joey getSelectedItemPosition : "+ mSpinner.getSelectedItemPosition());
		return v;
	}
}
