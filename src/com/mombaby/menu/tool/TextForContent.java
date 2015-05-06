package com.mombaby.menu.tool;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mombaby.MombabyPod.R;

public class TextForContent extends ArrayAdapter<String> {
	private LayoutInflater mInflater;
	private String[] mString;
	private int mViewResource;
	public ArrayList<String> activityList = new ArrayList<String>();

	public TextForContent(Context context, int Viewresource, String[] strings) {
		super(context, Viewresource, strings);
		mInflater = (LayoutInflater) context
				.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		mViewResource = Viewresource;
		mString = strings;

	}

	public TextForContent(Context ctx, int contentList, ArrayList<String> acList) {
		super(ctx, contentList, acList);
		mInflater = (LayoutInflater) ctx
				.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
		mViewResource = contentList;
		activityList = acList;

	}

	public void refresh(ArrayList<String> list) {
		activityList = list;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		// return mString.length;
		// json檔
		return activityList.size();
	}

	@Override
	public String getItem(int position) {
		// TODO Auto-generated method stub
		// return mString[position];
		// json檔
		return activityList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	// 原版
	// @Override
	// public View getView(int position, View convertView, ViewGroup parent) {
	// convertView = mInflater.inflate(mViewResource, null);
	// TextView tv = (TextView) convertView.findViewById(R.id.contenttext1_b);
	// tv.setText(mString[position]);
	// TextView tv2 = (TextView) convertView.findViewById(R.id.contenttext2_b);
	// tv2.setText(mString[position]);
	// return convertView;
	// }

	// 這個是有抓Json檔案的
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		convertView = mInflater.inflate(mViewResource, null);
		TextView tv = (TextView) convertView.findViewById(R.id.contenttext1_b);
		tv.setText(activityList.get(position));
		TextView tv2 = (TextView) convertView.findViewById(R.id.contenttext2_b);
		tv2.setText(activityList.get(position));
		return convertView;
	}

}