package com.mombaby.MombabyPod.menu;

<<<<<<< HEAD
import android.content.Context;
=======
<<<<<<< HEAD
import android.content.Context;
=======
import android.app.Fragment;
import android.content.Context;
import com.mombaby.MombabyPod.context.ContextA;
import android.content.Intent;
>>>>>>> origin/master
>>>>>>> origin/master
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
<<<<<<< HEAD
import android.widget.TextView;
=======
<<<<<<< HEAD
import android.widget.TextView;
=======
>>>>>>> origin/master
>>>>>>> origin/master

import com.mombaby.MombabyPod.menu.tool.ImageAndTextForContent;
import com.mombaby.MombabyPod.system.SystemApplication;
import com.mombaby.MombabyPod.MainActivity;
import com.mombaby.MombabyPod.R;
<<<<<<< HEAD
import com.mombaby.MombabyPod.menu.tool.AbsListViewBaseFragment;
import com.mombaby.MombabyPod.tool.RefreshableView;
import com.mombaby.MombabyPod.tool.RefreshableView.PullToRefreshListener;
=======
<<<<<<< HEAD
import com.mombaby.MombabyPod.menu.tool.AbsListViewBaseFragment;
import com.mombaby.MombabyPod.tool.RefreshableView;
import com.mombaby.MombabyPod.tool.RefreshableView.PullToRefreshListener;
=======
import com.mombaby.MombabyPod.menu.tool.ImageAdapter;
import com.mombaby.MombabyPod.menu.tool.AbsListViewBaseFragment;

>>>>>>> origin/master
>>>>>>> origin/master

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
<<<<<<< HEAD
	TextView Header_title_a ,Header_content_a;
	RefreshableView refreshableView; 
=======
<<<<<<< HEAD
	TextView Header_title_a ,Header_content_a;
	RefreshableView refreshableView; 
=======
>>>>>>> origin/master
>>>>>>> origin/master

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
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
		Header_title_a = (TextView) mHeader.findViewById(R.id.header_title_a);
		Header_content_a = (TextView) mHeader.findViewById(R.id.header_content_a);
		Custom_listView = (ListView) view.findViewById(R.id.listView_a);
		this.icons = ctx.getResources().obtainTypedArray(
				R.array.contentimagearray);
		
		CustomReflash(view);
<<<<<<< HEAD
=======
=======
		Custom_listView = (ListView) view.findViewById(R.id.listView_a);
		this.icons = ctx.getResources().obtainTypedArray(
				R.array.contentimagearray);

>>>>>>> origin/master
>>>>>>> origin/master
		Data_StyleA();
		return view;
	}

	public void Data_StyleA() {	
		ImageAndTextAdapter = new ImageAndTextForContent(ctx,
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
				R.layout.content_list, 
				SystemApplication.ArticleList_title,
				SystemApplication.ArticleList_short_desp,
				SystemApplication.ArticleList_pic ,HeaderImage ,progressbar
				,Header_title_a, Header_content_a);
<<<<<<< HEAD
=======
=======
				R.layout.content_list, SystemApplication.ArticleList_title,
				SystemApplication.ArticleList_pic ,HeaderImage ,progressbar);
>>>>>>> origin/master
>>>>>>> origin/master
		Log.v(TAG, "joey PIC Data_StyleA()" +SystemApplication.ArticleList_pic);
		Custom_listView.addHeaderView(mHeader);
		Custom_listView.setAdapter(ImageAndTextAdapter);
		
<<<<<<< HEAD
	
=======
<<<<<<< HEAD
	
=======
		//Content_list.setAdapter(new ImageAdapter(getActivity(),SystemApplication.ArticleList_pic));
>>>>>>> origin/master
>>>>>>> origin/master
		Custom_listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				Log.v(TAG,
						"joey onItemClick SystemApplication.ArticleList_title : "
								+ SystemApplication.ArticleList_title.size());
				Log.v(TAG, "joey onItemClick :" + position);
				startImagePagerActivity(position);
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
				//文章內容
				//main.DataBase_ContentList(position);
>>>>>>> origin/master
>>>>>>> origin/master
			}
		});
	}
	
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
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
	
<<<<<<< HEAD
=======
=======
>>>>>>> origin/master
>>>>>>> origin/master
	//重新整理
	public void refreshA(){
		ImageAndTextAdapter = new ImageAndTextForContent(main,
				R.layout.content_list, SystemApplication.ArticleList_title,
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
				SystemApplication.ArticleList_short_desp,
				SystemApplication.ArticleList_pic ,HeaderImage ,progressbar,Header_title_a, Header_content_a);
		// this.icons
		ImageAndTextAdapter.refresh(SystemApplication.ArticleList_title,SystemApplication.ArticleList_short_desp);
<<<<<<< HEAD
=======
=======
				SystemApplication.ArticleList_pic ,HeaderImage ,progressbar);
		// this.icons
		ImageAndTextAdapter.refresh(SystemApplication.ArticleList_title);
>>>>>>> origin/master
>>>>>>> origin/master
	}
	


}
