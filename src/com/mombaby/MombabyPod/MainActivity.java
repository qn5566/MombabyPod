package com.mombaby.MombabyPod;

import java.util.ArrayList;

import com.mombaby.MombabyPod.R;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import com.mombaby.menu.StyleAA;
import com.mombaby.menu.StyleBB;
import com.mombaby.menu.StyleCC;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import com.navdrawer.SimpleSideDrawer;
import com.mombaby.data.DataBase_TitleList;
import com.mombaby.data.DataBase_ArticleList;
import com.mombaby.data.DataBase_ContentList;
import com.mombaby.system.SystemApplication;
import com.mombaby.menu.StyleA;
import com.mombaby.menu.StyleB;
import com.mombaby.menu.StyleC;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	OnClickListener OnCustomClick;
	SimpleSideDrawer vSlideHolder;
	ListView Style_menu;
	String[] data = new String[] { "樣式一", "樣式二", "樣式三" };
	DataBase_TitleList TitleData;
	DataBase_ArticleList ArticleData;
	DataBase_ContentList ContentData;
	StyleAA stylea;
	StyleBB styleb;
	StyleCC stylec;

	public static ArrayList<String> TitleList = new ArrayList<String>();
	public static ArrayList<String> Title_id = new ArrayList<String>();

	String TAG = "MainActivity";
	ArrayAdapter<String> arrAdapSpnRegion2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initMeun();
		
		DataTitle();
		// TopTitle();
		StyleSetting();
	}
	
	//初始化Menu選單
	public void initMeun(){
		stylea = new StyleAA(this);
		styleb = new StyleBB(this);
		stylec = new StyleCC(this);
	}
	
	// 資料抓取Title
	public void DataTitle() {
		TitleData = new DataBase_TitleList(this, TitleList, Title_id);
		TitleData.execute();

	}

	// 資料抓取Title內容
	public void DataTitle_con(int pos) {
		ArticleData = new DataBase_ArticleList(this,
				SystemApplication.ArticleList_title,
				SystemApplication.ArticleList_rkey,
				SystemApplication.ArticleList_brief,
				SystemApplication.ArticleList_pic,
				stylea, styleb, stylec);
		Log.v(TAG, "joey SystemApplication.Title_id.get(pos) : "
				+ SystemApplication.Title_id.get(pos));
		ArticleData.execute(SystemApplication.Title_id.get(pos));

	}

	
	
	// 客製化的TitleBar
	public void TopTitle() {
		ActionBar mActionBar = getSupportActionBar();
		mActionBar.setDisplayShowHomeEnabled(false);
		mActionBar.setDisplayShowTitleEnabled(false);
		mActionBar.setDisplayShowCustomEnabled(true);
		LayoutInflater mInflater = LayoutInflater.from(this);
		// 客製化的View帶入
		View mCustomView = mInflater.inflate(R.layout.title_bar, null);
		ImageView imageviewbtn = null;
		// 設定事件
		int titleOnClick[] = { R.id.style_btn, R.id.search_btn };
		for (int i = 0; i < titleOnClick.length; i++) {
			if ((imageviewbtn = (ImageView) mCustomView
					.findViewById(titleOnClick[i])) != null)
				imageviewbtn.setOnClickListener(this);
		}
		// 頻道設定
		Spinner mTitleTextView = (Spinner) mCustomView
				.findViewById(R.id.title_text);
		Log.v(TAG, "joey TitleData.activityList :"
				+ SystemApplication.TitleList);
		ArrayAdapter<String> arrAdapSpnRegion2 = new ArrayAdapter<String>(this,
				R.layout.spinner_item, SystemApplication.TitleList);
		// ArrayAdapterForSpinnerRegion arrAdapSpnRegion2 = new
		// ArrayAdapterForSpinnerRegion(
		// this, R.layout.spinner_item, TitleData.activityList
		// , mTitleTextView);
		// Title設定
		arrAdapSpnRegion2
				.setDropDownViewResource(R.layout.spinner_dropdown_item);

		mTitleTextView.setAdapter(arrAdapSpnRegion2);
		mTitleTextView.setOnItemSelectedListener(spnRegionOnItemSelected);

		// mTitleTextView.setOnClickListener(this);
		mActionBar.setCustomView(mCustomView);

	}

	// Style設定導覽鍵
	public void StyleSetting() {
		vSlideHolder = new SimpleSideDrawer(this);
		vSlideHolder.setLeftBehindContentView(R.layout.style_setting);
		Style_menu = (ListView) findViewById(R.id.style_menu);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, data);
		Style_menu.setAdapter(adapter);
		Style_menu
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						selectItem(position);
					}
				});
	}

	// 選擇切換Style
	private void selectItem(int position) {
		Fragment fragment = null;

		switch (position) {
		case 0:
			fragment = new StyleAA();
			break;

		case 1:
			fragment = new StyleBB();
			break;

		case 2:
			fragment = new StyleCC();
			break;
		}

		FragmentTransaction tran = getFragmentManager().beginTransaction();
		tran.replace(R.id.home_layout, fragment).commit();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.style_btn:
			Toast.makeText(getApplicationContext(), "選擇你要的style",
					Toast.LENGTH_LONG).show();

			vSlideHolder.toggleLeftDrawer();
			break;
		case R.id.search_btn:
			Toast.makeText(getApplicationContext(), "搜尋東西", Toast.LENGTH_LONG)
					.show();
			break;
		case R.id.title_text:
			Toast.makeText(getApplicationContext(), "你成功摟", Toast.LENGTH_LONG)
					.show();
			break;
		}

	}

	
	// 標題選單
	private Spinner.OnItemSelectedListener spnRegionOnItemSelected = new Spinner.OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View v, int position,
				long id) {
			DataTitle_con(position);
			
			
			Toast.makeText(getApplicationContext(), "你選擇了" + position,
					Toast.LENGTH_SHORT).show();

		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub

		}

	};

}
