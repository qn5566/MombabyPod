package com.mombaby.MombabyPod.system;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.StrictMode;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SystemApplication extends Application {
	// ----------------圖片
	public static String ArticleList_Pic_Path = "http://mpod.elaiis.com";
	// ---------------第一
	public static ArrayList<String> TitleList = new ArrayList<String>();
	public static ArrayList<String> Title_id = new ArrayList<String>();
	// ---------------第二
	public static ArrayList<String> ArticleList_title = new ArrayList<String>();
	public static ArrayList<String> ArticleList_rkey = new ArrayList<String>();
	public static ArrayList<String> ArticleList_brief = new ArrayList<String>();
	public static ArrayList<String> ArticleList_pic = new ArrayList<String>();
	public static ArrayList<String> ArticleList_short_desp = new ArrayList<String>();
	// ----------------第三
	public static ArrayList<String> Context_title = new ArrayList<String>();
	public static ArrayList<String> Context_brief = new ArrayList<String>();
	public static ArrayList<String> Context_desp = new ArrayList<String>();
	//-----------------新增網頁位置
	public static ArrayList<String> Context_Web = new ArrayList<String>();
	// ----------------圖片放置
	public static ArrayList<String> IMAGE_URLS = new ArrayList<String>();

	public static Boolean StyleA = false;
	public static Boolean StyleB = false;
	public static Boolean StyleC = false;

	public static class Config {
		public static final boolean DEVELOPER_MODE = false;
	}

	public static Boolean Context_Change = false;

	public void onCreate() {
		if (Config.DEVELOPER_MODE
				&& Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
			StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
					.detectAll().penaltyDialog().build());
			StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
					.detectAll().penaltyDeath().build());
		}

		super.onCreate();

		initImageLoader(getApplicationContext());
	}

	// 讀取網路圖片，型態為Bitmap
	public static Bitmap getBitmapFromURL(String imageUrl) {
		try {
			URL url = new URL(imageUrl);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoInput(true);
			connection.connect();
			InputStream input = connection.getInputStream();
			Bitmap bitmap = BitmapFactory.decodeStream(input);
			return bitmap;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void initImageLoader(Context context) {
		ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(
				context);
		config.threadPriority(Thread.NORM_PRIORITY - 2);
		config.denyCacheImageMultipleSizesInMemory();
		config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
		config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
		config.tasksProcessingOrder(QueueProcessingType.LIFO);
		config.writeDebugLogs(); // Remove for release app

		// Initialize ImageLoader with configuration.
		ImageLoader.getInstance().init(config.build());
	}

	public static Bitmap decodeSampledBitmapFromResource(Resources res,
			int resId, int reqWidth, int reqHeight) {

		// First decode with inJustDecodeBounds=true to check dimensions
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		options.inPurgeable = true;
		BitmapFactory.decodeResource(res, resId, options);
		// Calculate inSampleSize
		options.inSampleSize = calculateInSampleSize(options, reqWidth,
				reqHeight);
		options.inPreferredConfig = Bitmap.Config.RGB_565;
		// Decode bitmap with inSampleSize set
		options.inJustDecodeBounds = false;
		return BitmapFactory.decodeResource(res, resId, options);
	}

	public static int calculateInSampleSize(BitmapFactory.Options options,
			int reqWidth, int reqHeight) {
		// Raw height and width of image
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;

		if (height > reqHeight || width > reqWidth) {
			// Calculate ratios of height and width to requested height and
			// width
			final int heightRatio = Math.round((float) height
					/ (float) reqHeight);
			final int widthRatio = Math.round((float) width / (float) reqWidth);

			// Choose the smallest ratio as inSampleSize value, this will
			// guarantee
			// a final image with both dimensions larger than or equal to the
			// requested height and width.
			inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
		}

		return inSampleSize;
	}

	public static void CleanTitleList(){
	TitleList.clear();
	Title_id.clear();
	}
	
	public static void CleanArticleList(){
		ArticleList_title.clear();
		ArticleList_rkey.clear();
		ArticleList_brief.clear();
		ArticleList_pic.clear();
		ArticleList_short_desp.clear();
	}
}
