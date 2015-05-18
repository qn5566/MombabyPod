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
import com.mombaby.MombabyPod.system.SystemApplication;
import com.mombaby.MombabyPod.system.SystemApplication.ViewHolder;
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

public class StyleC extends AbsListViewBaseFragment {
	MainActivity main;
	static String TAG = "StyleC";
	View mHeader;
	// GridViewWithHeaderAndFooter gridView;
	ContextText context;
	ImageAdapter imageAdapter;
	ImageView HeaderImage;
	ProgressBar progressbar;

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

		ImageAdapter(Context context, ArrayList<String> Pic, ImageView headerImage,
				ProgressBar progressbar) {
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
				view.setTag(holder);
			} else {
				holder = (ViewHolder) view.getTag();
			}

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

	
}