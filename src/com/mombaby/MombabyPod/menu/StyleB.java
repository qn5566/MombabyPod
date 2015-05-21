package com.mombaby.MombabyPod.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
<<<<<<< HEAD
import android.widget.TextView;
=======
<<<<<<< HEAD
import android.widget.TextView;
=======
>>>>>>> origin/master
>>>>>>> origin/master
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ProgressBar;

import com.mombaby.MombabyPod.menu.tool.TextForContent;
import com.mombaby.MombabyPod.system.SystemApplication;

import com.mombaby.MombabyPod.menu.tool.AbsListViewBaseFragment;
import com.mombaby.MombabyPod.MainActivity;
import com.mombaby.MombabyPod.R;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
import com.mombaby.MombabyPod.tool.RefreshableView;
import com.mombaby.MombabyPod.tool.RefreshableView.PullToRefreshListener;

public class StyleB extends AbsListViewBaseFragment {

<<<<<<< HEAD
=======
=======

public class StyleB extends AbsListViewBaseFragment {


>>>>>>> origin/master
>>>>>>> origin/master
	public Context ctx;
	public TextForContent TextAdapter;
	private TypedArray icons;
	public String TAG = "StyleB";
	MainActivity main;
	View mHeader;
	ImageView HeaderImage;
	ProgressBar progressbar;
<<<<<<< HEAD
	TextView Header_title_b, Header_content_b;
	RefreshableView refreshableView;
=======
<<<<<<< HEAD
	TextView Header_title_b, Header_content_b;
	RefreshableView refreshableView;
=======
>>>>>>> origin/master
>>>>>>> origin/master

	public StyleB() {
		// TODO Auto-generated constructor stub
	}

	public StyleB(MainActivity Main) {
		main = Main;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.v(TAG, "joey StyleB : onCreate");
		this.ctx = getActivity();
		SystemApplication.StyleB = true;
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
		
>>>>>>> origin/master
>>>>>>> origin/master
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return initView(inflater, container);
	}

	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.style_b, container, false);
		mHeader = inflater.inflate(R.layout.style_headerb, null);
		HeaderImage = (ImageView) mHeader.findViewById(R.id.header_image_b);
		progressbar = (ProgressBar) mHeader.findViewById(R.id.progress);
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
		Header_title_b = (TextView) mHeader.findViewById(R.id.header_title_b);
		Header_content_b = (TextView) mHeader
				.findViewById(R.id.header_content_b);
		// HeaderImage.setVisibility(View.GONE);
		Log.v(TAG, "joey HeaderImage : " + HeaderImage);
		TextAdapter = new TextForContent(ctx, R.layout.content_list2,
				SystemApplication.ArticleList_title, HeaderImage, progressbar,
				Header_title_b, Header_content_b);
		Custom_listView = (ListView) view.findViewById(R.id.listView_b);
		CustomReflash(view);
<<<<<<< HEAD
=======
=======
		//HeaderImage.setVisibility(View.GONE);
		Log.v(TAG,"joey HeaderImage : "+ HeaderImage);
		TextAdapter = new TextForContent(ctx, R.layout.content_list2,
				SystemApplication.ArticleList_title,HeaderImage, progressbar);
		Custom_listView = (ListView) view.findViewById(R.id.listView_b);

>>>>>>> origin/master
>>>>>>> origin/master
		Data_StyleB();

		return view;
	}

	public void Data_StyleB() {
		Custom_listView.addHeaderView(mHeader);
		Custom_listView.setAdapter(TextAdapter);
		Custom_listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Log.v(TAG,
						"joey onItemClick SystemApplication.ArticleList_pic.size : "
								+ SystemApplication.ArticleList_pic.size());
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
				// int adjust = (position - 1 < 0) ? 0 : position - 1;
				Log.v(TAG, "joey onItemClick :" + position);
				startImagePagerActivity(position);
				// 文章內容
<<<<<<< HEAD
=======
=======
				//int adjust = (position - 1 < 0) ? 0 : position - 1;
				Log.v(TAG, "joey onItemClick :" + position);
				startImagePagerActivity(position);
				//文章內容
>>>>>>> origin/master
>>>>>>> origin/master

			}
		});
	}

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
	// 下滑更新
	public void CustomReflash(View view) {
		refreshableView = (RefreshableView) view
				.findViewById(R.id.refreshable_view);
		refreshableView.setOnRefreshListener(new PullToRefreshListener() {
			@Override
			public void onRefresh() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				refreshableView.finishRefreshing();
			}
		}, 0);

	}

	// 重新整理
	public void refreshB() {
		 TextAdapter = new TextForContent(main, R.layout.content_list2,
		 SystemApplication.ArticleList_title,HeaderImage,progressbar,Header_title_b,Header_content_b);
		 TextAdapter.notifyDataSetChanged();
<<<<<<< HEAD
=======
=======
	// 重新整理
	public void refreshB() {
//		TextAdapter = new TextForContent(main, R.layout.content_list2,
//				SystemApplication.ArticleList_title,HeaderImage);
//		TextAdapter.notifyDataSetChanged();
>>>>>>> origin/master
>>>>>>> origin/master

	}

}
