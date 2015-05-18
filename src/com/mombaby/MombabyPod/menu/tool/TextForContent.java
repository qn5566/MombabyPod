package com.mombaby.MombabyPod.menu.tool;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mombaby.MombabyPod.R;

import com.mombaby.MombabyPod.system.SystemApplication;
import com.mombaby.MombabyPod.system.SystemApplication.ViewHolder;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class TextForContent extends ArrayAdapter<String> {
	private LayoutInflater mInflater;
	private String[] mString;
	private int mViewResource;
	ImageView HeaderImage;
	ProgressBar Progressbar;
	private DisplayImageOptions options;
	

	public TextForContent(Context ctx, int contentList,
			ArrayList<String> acList, ImageView headerImage, ProgressBar progressbar) {
		super(ctx, contentList, acList);
		mInflater = (LayoutInflater) ctx
				.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
		mViewResource = contentList;
		SystemApplication.ArticleList_title = acList;

		options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.ic_stub)
				.showImageForEmptyUri(R.drawable.ic_empty)
				.showImageOnFail(R.drawable.ic_error).cacheInMemory(true)
				.cacheOnDisk(true).considerExifParams(true)
				.bitmapConfig(Bitmap.Config.RGB_565)
				.imageScaleType(ImageScaleType.EXACTLY_STRETCHED).build();

		HeaderImage = headerImage;

		Progressbar = progressbar;
	}

	public void refresh(ArrayList<String> list) {
		SystemApplication.ArticleList_title = list;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		int adjust = SystemApplication.ArticleList_title.size() - 1;
		// json檔
		return adjust;
	}

	@Override
	public String getItem(int position) {
		// json檔
		return SystemApplication.ArticleList_title.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	// 這個是有抓Json檔案的
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		int adjust = position + 1;
		convertView = mInflater.inflate(mViewResource, null);
		TextView tv = (TextView) convertView.findViewById(R.id.contenttext1_b);
		tv.setText(SystemApplication.ArticleList_title.get(adjust));
		TextView tv2 = (TextView) convertView.findViewById(R.id.contenttext2_b);
		tv2.setText(SystemApplication.ArticleList_title.get(adjust));
		ImageLoader.getInstance().displayImage(
				SystemApplication.ArticleList_pic.get(0), HeaderImage,
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
		return convertView;
	}
	
}