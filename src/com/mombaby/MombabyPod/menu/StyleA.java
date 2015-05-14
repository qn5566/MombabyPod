package com.mombaby.MombabyPod.menu;

import android.app.Fragment;
import android.content.Context;
import com.mombaby.MombabyPod.context.ContextA;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.mombaby.MombabyPod.menu.tool.ImageAndTextForContent;
import com.mombaby.MombabyPod.system.SystemApplication;
import com.mombaby.MombabyPod.MainActivity;
import com.mombaby.MombabyPod.R;
import com.mombaby.MombabyPod.menu.tool.ImageAdapter;
import com.mombaby.MombabyPod.menu.tool.AbsListViewBaseFragment;


public class StyleA extends AbsListViewBaseFragment {
	//private ListView Content_list;
	private String[] ContentTitle;
	Context ctx;
	ImageAndTextForContent ImageAndTextAdapter ; 
	private TypedArray icons;
	String TAG ="StyleA";
	MainActivity main;

	public StyleA (){
		
	}
	
	public StyleA (MainActivity Main){
		main = Main ;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.v(TAG,"joey StyleA : onCreate");
		SystemApplication.StyleA = true;
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		this.ctx = getActivity();
		ContentTitle = new String[] { "Afghanistan", "Albania", "Algeria",
				"American Samoa", "Andorra" };

		return initView(inflater, container);
	}

	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.style_a, container, false);
		listView = (ListView) view.findViewById(R.id.listView_a);
		this.icons = ctx.getResources().obtainTypedArray(
				R.array.contentimagearray);

		Data_StyleA();
		return view;
	}

	public void Data_StyleA() {
	
		ImageAndTextAdapter = new ImageAndTextForContent(ctx,
				R.layout.content_list, SystemApplication.ArticleList_title,
				SystemApplication.ArticleList_pic);
		Log.v(TAG, "joey PIC Data_StyleA()" +SystemApplication.ArticleList_pic);
		listView.setAdapter(ImageAndTextAdapter);
		
		//Content_list.setAdapter(new ImageAdapter(getActivity(),SystemApplication.ArticleList_pic));
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				startImagePagerActivity(position);
				//文章內容
				//main.DataBase_ContentList(position);
			}
		});
	}
	
	//重新整理
	public void refreshA(){
		ImageAndTextAdapter = new ImageAndTextForContent(main,
				R.layout.content_list, SystemApplication.ArticleList_title,
				SystemApplication.ArticleList_pic);
		// this.icons
		ImageAndTextAdapter.refresh(SystemApplication.ArticleList_title);
	}
	


}
