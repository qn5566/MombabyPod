package com.mombaby.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.mombaby.menu.tool.TextForContent;
import com.mombaby.system.SystemApplication;

import com.mombaby.menu.tool.AbsListViewBaseFragment;
import com.mombaby.MombabyPod.MainActivity;
import com.mombaby.MombabyPod.R;

public class StyleBB extends AbsListViewBaseFragment {

	// private ListView Content_list;
	//private String[] ContentTitle;
	public Context ctx;
	public TextForContent TextAdapter;
	private TypedArray icons;
	public String TAG = "StyleB";
	MainActivity main;

	public StyleBB() {
		// TODO Auto-generated constructor stub
	}

	public StyleBB(MainActivity Main) {
		main = Main;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.v(TAG, "joey StyleB : onCreate");
		this.ctx = getActivity();
		SystemApplication.StyleB = true;
		TextAdapter = new TextForContent(ctx, R.layout.content_list2,
				SystemApplication.ArticleList_title);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
//		ContentTitle = new String[] { "Afghanistan", "Albania", "Algeria",
//				"American Samoa", "Andorra" };
		return initView(inflater, container);
	}

	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.style_b, container, false);
		listView = (ListView) view.findViewById(R.id.listView_b);

		// Content_list.setAdapter(new TextForContent(ctx,
		// R.layout.content_list2, SystemApplication.ArticleList_title ));
		// Content_list.setOnItemClickListener(this);
		Data_StyleB();

		return view;
	}

	public void Data_StyleB() {
		listView.setAdapter(TextAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				startImagePagerActivity(position);
			}
		});
	}

	// 重新整理
	public void refreshB() {
		TextAdapter = new TextForContent(main, R.layout.content_list2,
				SystemApplication.ArticleList_title);
		TextAdapter.notifyDataSetChanged();

	}

}
