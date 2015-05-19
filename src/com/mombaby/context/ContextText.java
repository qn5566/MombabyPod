package com.mombaby.context;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mombaby.MombabyPod.R;

public class ContextText extends ArrayAdapter<String> {
	private LayoutInflater mInflater;
	private int mViewResource;
	public ArrayList<String> context_brief = new ArrayList<String>();
	public ArrayList<String> context_desp = new ArrayList<String>();

	public ContextText(Context ctx, int contentList, ArrayList<String> brief,
			ArrayList<String> desp) {
		super(ctx, contentList, brief);
		mInflater = (LayoutInflater) ctx
				.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
		mViewResource = contentList;
		context_brief = brief;
		context_desp = desp;
	}

	public void refresh(ArrayList<String> brief, ArrayList<String> desp) {
		context_brief = brief;
		context_desp = desp;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		// json檔
		return context_brief.size();
	}

	@Override
	public String getItem(int position) {
		// json檔
		return context_brief.get(position);
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
		tv.setText(context_brief.get(position));
		TextView tv2 = (TextView) convertView.findViewById(R.id.context_View2);
		tv2.setText(context_desp.get(position));
		return convertView;
	}

}