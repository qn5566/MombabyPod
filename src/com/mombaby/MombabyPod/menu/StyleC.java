package com.mombaby.MombabyPod.menu;

import java.util.ArrayList;
import android.graphics.Bitmap;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
<<<<<<< HEAD
import android.widget.TextView;

import com.mombaby.MombabyPod.system.SystemApplication;
=======
import com.mombaby.MombabyPod.system.SystemApplication;
import com.mombaby.MombabyPod.system.SystemApplication.ViewHolder;
>>>>>>> origin/master
import com.mombaby.MombabyPod.MainActivity;
import com.mombaby.MombabyPod.R;
import com.mombaby.MombabyPod.context.ContextText;
import com.mombaby.MombabyPod.menu.tool.AbsListViewBaseFragment;
import com.mombaby.MombabyPod.menu.tool.TextForContent;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.mombaby.MombabyPod.menu.tool.GridViewWithHeaderAndFooter;
<<<<<<< HEAD
import com.mombaby.MombabyPod.tool.RefreshableView;
import com.mombaby.MombabyPod.tool.RefreshableView.PullToRefreshListener;
=======
>>>>>>> origin/master

public class StyleC extends AbsListViewBaseFragment {
	MainActivity main;
	static String TAG = "StyleC";
	View mHeader;
	// GridViewWithHeaderAndFooter gridView;
	ContextText context;
	ImageAdapter imageAdapter;
	ImageView HeaderImage;
	ProgressBar progressbar;
<<<<<<< HEAD
	TextView Header_title_c ,Header_content_c;
	RefreshableView refreshableView; 
=======
>>>>>>> origin/master

	public static final int INDEX = 1;

	public StyleC() {
		// TODO Auto-generated constructor stub
	}

	public StyleC(MainActivity Main) {
		main = Main;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.v(TAG, "joey StyleA : onCreate");
		SystemApplication.StyleC = true;
		main = new MainActivity();

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.style_c, container, false);
<<<<<<< HEAD
		//設定首圖
		mHeader = inflater.inflate(R.layout.style_headerc, null);
		progressbar = (ProgressBar) mHeader.findViewById(R.id.progress);
		HeaderImage = (ImageView) mHeader.findViewById(R.id.header_image_c);
		Header_title_c = (TextView) mHeader.findViewById(R.id.header_title_c);
		Header_content_c = (TextView) mHeader.findViewById(R.id.header_content_c);
		//設定其他組圖
		GridView = (GridViewWithHeaderAndFooter) rootView
				.findViewById(R.id.grid_view);
		GridView.addHeaderView(mHeader);
//		CustomReflash(rootView);
		imageAdapter = new ImageAdapter(getActivity(),
				SystemApplication.ArticleList_pic,HeaderImage,progressbar ,Header_title_c, Header_content_c);
=======
		mHeader = inflater.inflate(R.layout.style_headerc, null);
		progressbar = (ProgressBar) mHeader.findViewById(R.id.progress);
		// listView = (GridView) rootView.findViewById(R.id.gridview);

		GridView = (GridViewWithHeaderAndFooter) rootView
				.findViewById(R.id.grid_view);
		HeaderImage = (ImageView) mHeader.findViewById(R.id.header_image_c);
		//HeaderImage.setVisibility(View.GONE);
		GridView.addHeaderView(mHeader);
		imageAdapter = new ImageAdapter(getActivity(),
				SystemApplication.ArticleList_pic,HeaderImage,progressbar);
>>>>>>> origin/master
		((GridViewWithHeaderAndFooter) GridView).setAdapter(imageAdapter);
		GridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Log.v(TAG,
						"joey onItemClick SystemApplication.ArticleList_pic.size : "
								+ SystemApplication.ArticleList_pic.size());
				//微調
				int adjust = (position - 2 < 0) ? 0 : position - 1;

				Log.v(TAG, "joey onItemClick :" + adjust);

				startImagePagerActivity(adjust);

			}
		});

		return rootView;
	}

<<<<<<< HEAD
//	//下滑更新
//		public void CustomReflash(View view){
//			refreshableView = (RefreshableView) view.findViewById(R.id.refreshable_view); 
//			refreshableView.setOnRefreshListener(new PullToRefreshListener() {  
//	            @Override  
//	            public void onRefresh() {  
//	                try {  
//	                    Thread.sleep(3000);  
//	                } catch (InterruptedException e) {  
//	                    e.printStackTrace();  
//	                }  
//	                refreshableView.finishRefreshing();  
//	            }  
//	        }, 0);  
//	     
//		}
=======
	
>>>>>>> origin/master


	// 重新整理
	public void refreshC() {
//		imageAdapter = new ImageAdapter(main, SystemApplication.ArticleList_pic,HeaderImage);
//		imageAdapter.refresh(SystemApplication.ArticleList_title);

	}

	/*
	 * 設定圖片擺飾
	 */
	private static class ImageAdapter extends BaseAdapter {

		private LayoutInflater inflater;

		private DisplayImageOptions options;
		
		ImageView HeaderImage;
		
		ProgressBar Progressbar;
<<<<<<< HEAD
		
		TextView Header_title_c ,Header_content_c;

		ImageAdapter(Context context, ArrayList<String> Pic, ImageView headerImage,
				ProgressBar progressbar,TextView header_title_c ,TextView header_content_c) {
=======

		ImageAdapter(Context context, ArrayList<String> Pic, ImageView headerImage,
				ProgressBar progressbar) {
>>>>>>> origin/master
			inflater = LayoutInflater.from(context);

			SystemApplication.IMAGE_URLS = Pic;

			options = new DisplayImageOptions.Builder()
					.showImageOnLoading(R.drawable.ic_stub)
					.showImageForEmptyUri(R.drawable.ic_empty)
					.showImageOnFail(R.drawable.ic_error).cacheInMemory(true)
					.cacheOnDisk(true).considerExifParams(true)
					.bitmapConfig(Bitmap.Config.RGB_565)
					.imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
					.build();

			HeaderImage = headerImage;
			
			Progressbar = progressbar;
<<<<<<< HEAD
			
			Header_title_c = header_title_c ;
			Header_content_c = header_content_c;
=======
>>>>>>> origin/master
		}

		/*
		 * 修改抓到的總數
		 */
		@Override
		public int getCount() {
			int adjust = SystemApplication.IMAGE_URLS.size() - 1;
			Log.v(TAG, "joey onItemClick getCount() :" + adjust);
			return adjust;
		}

		@Override
		public Object getItem(int position) {
			Log.v(TAG, "joey onItemClick getItem :" + position);
			return null;
		}

		@Override
		public long getItemId(int position) {
			// int adjust = position-1;
			Log.v(TAG, "joey onItemClick getItemId  :" + position);
			return position;
		}

		public void refresh(ArrayList<String> list) {
			SystemApplication.IMAGE_URLS = list;
			notifyDataSetChanged();
		}

		/*
		 * 修改第一個顯示的圖示
		 */
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			final ViewHolder holder;
			View view = convertView;
			int adjust = position + 1;
			Log.v(TAG, "joey onItemClick getView :" + adjust);
			if (view == null) {
				view = inflater
						.inflate(R.layout.item_grid_image, parent, false);
				holder = new ViewHolder();
				assert view != null;
				holder.imageView = (ImageView) view.findViewById(R.id.image);
				holder.progressBar = (ProgressBar) view
						.findViewById(R.id.progress);
<<<<<<< HEAD
				holder.Style_title_c = (TextView)view.findViewById(R.id.style_title_c);
				holder.Style_content_c = (TextView)view.findViewById(R.id.style_content_c);
=======
>>>>>>> origin/master
				view.setTag(holder);
			} else {
				holder = (ViewHolder) view.getTag();
			}
<<<<<<< HEAD
			//首頁設置
			Header_title_c.setText(SystemApplication.ArticleList_title.get(0));
			Header_content_c.setText(SystemApplication.ArticleList_short_desp.get(0));
=======

>>>>>>> origin/master
			ImageLoader.getInstance().displayImage(
					SystemApplication.IMAGE_URLS.get(0), HeaderImage,
					options, new SimpleImageLoadingListener() {
						@Override
						public void onLoadingStarted(String imageUri, View view) {
							Progressbar.setProgress(0);
							Progressbar.setVisibility(View.VISIBLE);
						}

						@Override
						public void onLoadingFailed(String imageUri, View view,
								FailReason failReason) {
							Progressbar.setVisibility(View.GONE);
						}

						@Override
						public void onLoadingComplete(String imageUri,
								View view, Bitmap loadedImage) {
							Progressbar.setVisibility(View.GONE);
						}
					}, new ImageLoadingProgressListener() {
						@Override
						public void onProgressUpdate(String imageUri,
								View view, int current, int total) {
							Progressbar.setProgress(Math.round(100.0f
									* current / total));
						}
					});
<<<<<<< HEAD
			//其他			
			holder.Style_title_c.setText(SystemApplication.ArticleList_title.get(adjust));
			holder.Style_content_c.setText(SystemApplication.ArticleList_short_desp.get(adjust));
=======
			
>>>>>>> origin/master
			ImageLoader.getInstance().displayImage(
					SystemApplication.IMAGE_URLS.get(adjust), holder.imageView,
					options, new SimpleImageLoadingListener() {
						@Override
						public void onLoadingStarted(String imageUri, View view) {
							holder.progressBar.setProgress(0);
							holder.progressBar.setVisibility(View.VISIBLE);
						}

						@Override
						public void onLoadingFailed(String imageUri, View view,
								FailReason failReason) {
							holder.progressBar.setVisibility(View.GONE);
						}

						@Override
						public void onLoadingComplete(String imageUri,
								View view, Bitmap loadedImage) {
							holder.progressBar.setVisibility(View.GONE);
						}
					}, new ImageLoadingProgressListener() {
						@Override
						public void onProgressUpdate(String imageUri,
								View view, int current, int total) {
							holder.progressBar.setProgress(Math.round(100.0f
									* current / total));
						}
					});

			return view;
		}
	}
<<<<<<< HEAD
	public static class ViewHolder {
		public ImageView imageView;
		public ProgressBar progressBar;
		public TextView Style_title_c, Style_content_c;
	}
=======

>>>>>>> origin/master
	
}