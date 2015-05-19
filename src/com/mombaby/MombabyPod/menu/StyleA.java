package com.mombaby.MombabyPod.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import com.mombaby.MombabyPod.menu.tool.ImageAndTextForContent;
import com.mombaby.MombabyPod.system.SystemApplication;
import com.mombaby.MombabyPod.MainActivity;
import com.mombaby.MombabyPod.R;
import com.mombaby.MombabyPod.menu.tool.AbsListViewBaseFragment;
import com.mombaby.MombabyPod.tool.RefreshableView;
import com.mombaby.MombabyPod.tool.RefreshableView.PullToRefreshListener;

public class StyleA extends AbsListViewBaseFragment {
	//private ListView Content_list;
//	private String[] ContentTitle;
	Context ctx;
	ImageAndTextForContent ImageAndTextAdapter ; 
	private TypedArray icons;
	String TAG ="StyleA";
	MainActivity main;
	View mHeader;
	ImageView HeaderImage;
	ProgressBar progressbar;
	TextView Header_title_a ,Header_content_a;
	RefreshableView refreshableView; 

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
//		ContentTitle = new String[] { "Afghanistan", "Albania", "Algeria",
//				"American Samoa", "Andorra" };

		return initView(inflater, container);
	}

	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.style_a, container, false);
		mHeader = inflater.inflate(R.layout.style_headera, null);
		HeaderImage = (ImageView) mHeader.findViewById(R.id.header_imagea);
		progressbar = (ProgressBar) mHeader.findViewById(R.id.progress);
		Header_title_a = (TextView) mHeader.findViewById(R.id.header_title_a);
		Header_content_a = (TextView) mHeader.findViewById(R.id.header_content_a);
		Custom_listView = (ListView) view.findViewById(R.id.listView_a);
		this.icons = ctx.getResources().obtainTypedArray(
				R.array.contentimagearray);
		
		CustomReflash(view);
		Data_StyleA();
		return view;
	}

	public void Data_StyleA() {	
		ImageAndTextAdapter = new ImageAndTextForContent(ctx,
				R.layout.content_list, 
				SystemApplication.ArticleList_title,
				SystemApplication.ArticleList_short_desp,
				SystemApplication.ArticleList_pic ,HeaderImage ,progressbar
				,Header_title_a, Header_content_a);
		Log.v(TAG, "joey PIC Data_StyleA()" +SystemApplication.ArticleList_pic);
		Custom_listView.addHeaderView(mHeader);
		Custom_listView.setAdapter(ImageAndTextAdapter);
		
	
		Custom_listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Log.v(TAG,
						"joey onItemClick SystemApplication.ArticleList_title : "
								+ SystemApplication.ArticleList_title.size());
				Log.v(TAG, "joey onItemClick :" + position);
				startImagePagerActivity(position);
			}
		});
	}
	
	//下滑更新
	public void CustomReflash(View view){
		refreshableView = (RefreshableView) view.findViewById(R.id.refreshable_view); 
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
	
	//重新整理
	public void refreshA(){
		ImageAndTextAdapter = new ImageAndTextForContent(main,
				R.layout.content_list, SystemApplication.ArticleList_title,
				SystemApplication.ArticleList_short_desp,
				SystemApplication.ArticleList_pic ,HeaderImage ,progressbar,Header_title_a, Header_content_a);
		// this.icons
		ImageAndTextAdapter.refresh(SystemApplication.ArticleList_title,SystemApplication.ArticleList_short_desp);
	}
	


}
