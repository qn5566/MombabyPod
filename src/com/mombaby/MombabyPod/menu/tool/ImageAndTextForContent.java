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
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mombaby.MombabyPod.R;
import com.mombaby.MombabyPod.system.SystemApplication;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class ImageAndTextForContent extends ArrayAdapter<String> {
	private LayoutInflater mInflater;
	private String[] mString;
	private TypedArray mIcon;
	private int mViewResource;
<<<<<<< HEAD
	public ArrayList<String> Contenttext1 = new ArrayList<String>();
	public ArrayList<String> Contenttext2 = new ArrayList<String>();
=======
	public ArrayList<String> activityList = new ArrayList<String>();
>>>>>>> origin/master
	public ArrayList<String> IMAGE_URLS = new ArrayList<String>();
	private DisplayImageOptions options;
	private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();
	String TAG = "ImageAndTextForContent";
	ProgressBar Progressbar;
	ImageView HeaderImage;
<<<<<<< HEAD
	TextView Header_title_a ,Header_content_a;

	public ImageAndTextForContent(Context context, int Viewresource,
			ArrayList<String> Title, ArrayList<String> Short_desp, ArrayList<String> Pic, ImageView headerImage, ProgressBar progressbar,
			TextView header_title_a ,TextView header_content_a) {
		super(context, Viewresource, Title  );
		mInflater = (LayoutInflater) context
				.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		mViewResource = Viewresource;
		Contenttext1 = Title;
		Contenttext2 = Short_desp;
		IMAGE_URLS = Pic;
		Header_title_a = header_title_a ;
		Header_content_a = header_content_a;
=======

	public ImageAndTextForContent(Context context, int Viewresource,
			ArrayList<String> acList, ArrayList<String> Pic, ImageView headerImage, ProgressBar progressbar) {
		super(context, Viewresource, acList);
		mInflater = (LayoutInflater) context
				.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		mViewResource = Viewresource;
		activityList = acList;
		IMAGE_URLS = Pic;
		
		
>>>>>>> origin/master
		
		options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.ic_stub)
				.showImageForEmptyUri(R.drawable.ic_empty)
				.showImageOnFail(R.drawable.ic_error).cacheInMemory(true)
				.cacheOnDisk(true).considerExifParams(true)
				.bitmapConfig(Bitmap.Config.RGB_565)
				.imageScaleType(ImageScaleType.EXACTLY_STRETCHED).build();
				
				//.displayer(new RoundedBitmapDisplayer(20)).build();
		
		Progressbar = progressbar;
		
		HeaderImage = headerImage;

	}



<<<<<<< HEAD
	public void refresh(ArrayList<String> Title, ArrayList<String> Short_desp) {
		Contenttext1 = Title;
		Contenttext2 = Short_desp;
		notifyDataSetChanged();
		
=======
	public void refresh(ArrayList<String> list) {
		activityList = list;
		notifyDataSetChanged();
>>>>>>> origin/master
	}

	@Override
	public int getCount() {
<<<<<<< HEAD
		int adjust = Contenttext1.size() - 1;
=======
		int adjust = activityList.size() - 1;
>>>>>>> origin/master
		// json檔
		return adjust;
	}

	@Override
	public String getItem(int position) {
		// TODO Auto-generated method stub
		// return mString[position];
		// json檔
<<<<<<< HEAD
		return Contenttext1.get(position);
=======
		return activityList.get(position);
>>>>>>> origin/master
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		int adjust = position + 1;
		convertView = mInflater.inflate(mViewResource, null);
		ImageView iv = (ImageView) convertView.findViewById(R.id.contentimage);
		ImageLoader.getInstance().displayImage(IMAGE_URLS.get(adjust), iv,
				options, animateFirstListener);
		TextView tv = (TextView) convertView.findViewById(R.id.contenttext1);
<<<<<<< HEAD
		tv.setText(Contenttext1.get(adjust));
		TextView tv2 = (TextView) convertView.findViewById(R.id.contenttext2);
		tv2.setText(Contenttext2.get(adjust));		
		Log.v(TAG,
				"joey PIC IMAGE_URLS.get(adjust)" + IMAGE_URLS.get(adjust));
		
		Header_title_a.setText(Contenttext1.get(0));
		Header_content_a.setText(Contenttext2.get(0));
=======
		tv.setText(activityList.get(adjust));
		Log.v(TAG,
				"joey PIC IMAGE_URLS.get(adjust)" + IMAGE_URLS.get(adjust));
		
>>>>>>> origin/master
		ImageLoader.getInstance().displayImage(
				IMAGE_URLS.get(0), HeaderImage,
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