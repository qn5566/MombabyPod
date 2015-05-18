package com.mombaby.MombabyPod.context;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mombaby.MombabyPod.R;
import com.mombaby.MombabyPod.system.SystemApplication;

public class ContextText extends BaseAdapter {
	private LayoutInflater mInflater;
	private static int mViewResource;
//	public ArrayList<String> context_brief = new ArrayList<String>();
//	public ArrayList<String> context_desp = new ArrayList<String>();
	public ContextA contextA;

	public ContextText() {

	}

	public ContextText(Context ctx, int contentList) {
		super();
		mInflater = (LayoutInflater) ctx
				.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
		mViewResource = contentList;
	}

	public ContextText(Context ctx, int contentList, ArrayList<String> brief,
			ArrayList<String> desp) {
		super();
		mInflater = (LayoutInflater) ctx
				.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
		mViewResource = contentList;
//		context_brief = brief;
//		context_desp = desp;
	}

	public void Refresh_ContextText(ArrayList<String> brief,
			ArrayList<String> desp) {
//		context_brief = brief;
//		context_desp = desp;

	}

	// public void Refresh_ContextText(ArrayList<String> brief,
	// ArrayList<String> desp) {
	// context_brief = brief;
	// context_desp = desp;
	// //notifyDataSetChanged();
	// }

	@Override
	public int getCount() {
		// json檔
		return SystemApplication.Context_brief.size();
	}

	@Override
	public String getItem(int position) {
		// json檔
		return SystemApplication.Context_brief.get(position);
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	// 這個是有抓Json檔案的
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = mInflater.inflate(mViewResource, null);
		TextView tv = (TextView) convertView.findViewById(R.id.context_View1);
		tv.setText(SystemApplication.Context_brief.get(position));
		TextView tv2 = (TextView) convertView.findViewById(R.id.context_View2);
		tv2.setText(SystemApplication.Context_desp.get(position));
		return convertView;
	}

}