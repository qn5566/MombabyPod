package com.mombaby.MombabyPod.menu.tool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mombaby.MombabyPod.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class ImageAndTextForContent extends ArrayAdapter<String> {
	private LayoutInflater mInflater;
	private String[] mString;
	private TypedArray mIcon;
	private int mViewResource;
	public ArrayList<String> activityList = new ArrayList<String>();
	public ArrayList<String> IMAGE_URLS = new ArrayList<String>();
	private DisplayImageOptions options;
	private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();
	String TAG = "ImageAndTextForContent";

	public ImageAndTextForContent(Context context, int Viewresource,
			ArrayList<String> acList, ArrayList<String> Pic) {
		super(context, Viewresource, acList);
		mInflater = (LayoutInflater) context
				.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		mViewResource = Viewresource;
		activityList = acList;
		IMAGE_URLS = Pic;
		options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.ic_stub)
				.showImageForEmptyUri(R.drawable.ic_empty)
				.showImageOnFail(R.drawable.ic_error)

				.cacheInMemory(true).cacheOnDisk(true).considerExifParams(true)
				.displayer(new RoundedBitmapDisplayer(20)).build();

	}

	public ImageAndTextForContent(Context context, int Viewresource,
			String[] strings, TypedArray icons) {
		super(context, Viewresource, strings);
		mInflater = (LayoutInflater) context
				.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		mViewResource = Viewresource;
		mString = strings;
		mIcon = icons;
	}

	public ImageAndTextForContent(Context ctx, int contentList,
			ArrayList<String> acList, TypedArray icons) {
		super(ctx, contentList, acList);
		mInflater = (LayoutInflater) ctx
				.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
		mViewResource = contentList;
		activityList = acList;
		mIcon = icons;
	}

	public void refresh(ArrayList<String> list) {
		activityList = list;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		// return mString.length;
		// json檔
		return activityList.size();
	}

	@Override
	public String getItem(int position) {
		// TODO Auto-generated method stub
		// return mString[position];
		// json檔
		return activityList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	// 原版
	// @Override
	// public View getView(int position, View convertView, ViewGroup parent) {
	// convertView=mInflater.inflate(mViewResource, null);
	// ImageView iv=(ImageView) convertView.findViewById(R.id.contentimage);
	// iv.setImageDrawable(mIcon.getDrawable(position));
	// //int image = iv.getWidth();
	// //Log.v("Joey", "joey Image.getWidth() : " + image);
	// TextView tv=(TextView) convertView.findViewById(R.id.contenttext1);
	// tv.setText(mString[position]);
	// TextView tv2=(TextView) convertView.findViewById(R.id.contenttext2);
	// tv2.setText(mString[position]);
	// return convertView;
	// }

	// 這個是有抓Json檔案的
	// @Override
	// public View getView(int position, View convertView, ViewGroup parent) {
	// convertView=mInflater.inflate(mViewResource, null);
	// ImageView iv=(ImageView) convertView.findViewById(R.id.contentimage);
	// iv.setImageDrawable(mIcon.getDrawable(position));
	// TextView tv=(TextView) convertView.findViewById(R.id.contenttext1);
	// tv.setText(activityList.get(position));
	// return convertView;
	// }

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = mInflater.inflate(mViewResource, null);
		ImageView iv = (ImageView) convertView.findViewById(R.id.contentimage);
		ImageLoader.getInstance().displayImage(IMAGE_URLS.get(position), iv,
				options, animateFirstListener);
		TextView tv = (TextView) convertView.findViewById(R.id.contenttext1);
		tv.setText(activityList.get(position));
		Log.v(TAG,
				"joey PIC IMAGE_URLS.get(position)" + IMAGE_URLS.get(position));
		return convertView;
	}

	private static class AnimateFirstDisplayListener extends
			SimpleImageLoadingListener {

		static final List<String> displayedImages = Collections
				.synchronizedList(new LinkedList<String>());

		@Override
		public void onLoadingComplete(String imageUri, View view,
				Bitmap loadedImage) {
			if (loadedImage != null) {
				ImageView imageView = (ImageView) view;
				boolean firstDisplay = !displayedImages.contains(imageUri);
				if (firstDisplay) {
					FadeInBitmapDisplayer.animate(imageView, 500);
					displayedImages.add(imageUri);
				}
			}
		}
	}

}