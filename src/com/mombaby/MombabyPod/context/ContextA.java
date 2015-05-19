package com.mombaby.MombabyPod.context;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.mombaby.MombabyPod.system.SystemApplication;
import com.mombaby.MombabyPod.data.DataBase_ContentList;

import com.mombaby.MombabyPod.tool.DynamicShareActionProvider;
import com.mombaby.MombabyPod.R;

public class ContextA extends ActionBarActivity {

	public ShareActionProvider mShareActionProvider;
	ListView Context_listView;
	View mHeader;
	ContextText context;
	DataBase_ContentList ContentData;
	String TAG = "ContextA";
	Thread ContextData;
	DynamicShareActionProvider provider;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contexta);
		Log.v(TAG,"joey onCreate");
		
		LayoutInflater inflater = (LayoutInflater) getSystemService(this.LAYOUT_INFLATER_SERVICE);
		mHeader = inflater.inflate(R.layout.context_header, null);
		Context_listView = (ListView) findViewById(R.id.Context_listView);
		context = new ContextText(this, R.layout.context_layout);
		Context_listView.addHeaderView(mHeader);
		Context_listView.setAdapter(context);
		InterData();

	}

	// 接受傳值的方法
	public void InterData(){
		int dataInt = (Integer) getIntent().getSerializableExtra("Data");
		Log.v(TAG, "joey InterData : " + dataInt);
		DataBase_(dataInt);

	}

	@Override
	protected void onPostResume() {
		Log.v(TAG,"joey onPostResume");
		super.onPostResume();
	}
	//返回
	@Override
	protected void onStop() {
		Log.v(TAG,"joey onStop()");
		super.onStop();
	}
	//關閉
	@Override
	protected void onDestroy() {
		Log.v(TAG,"joey onDestroy()");
		if (ContentData != null && ContentData.getStatus() == AsyncTask.Status.RUNNING) {
			ContentData.cancel(true); 
			Log.v(TAG,"joey ContentData is Live and will be ");
		}
		SystemApplication.Context_brief.clear();
		SystemApplication.Context_desp.clear();
		Log.v(TAG, "joey Context_brief.clear() Context_desp.clear()" );
		super.onDestroy();
	}

	@Override
	protected void onRestart() {
		Log.v(TAG,"joey onRestart()");
		super.onRestart();
	}

	// 抓取內文資料
	public void DataBase_(int pos) {
		ContentData = new DataBase_ContentList(this);
		ContentData.execute(SystemApplication.ArticleList_rkey.get(pos));
	}



	// 更新訊息
	public void initContextText() {

		this.runOnUiThread(new Runnable() {

			@Override
			public void run() {
				context.Refresh_ContextText(SystemApplication.Context_brief,
						SystemApplication.Context_desp);
				Log.v(TAG, "joey Context_brief :"
						+ SystemApplication.Context_brief.size() + "  Context_desp :"
						+ SystemApplication.Context_desp.size());
				context.notifyDataSetChanged();
				Log.v(TAG, "joey initContextText 2");
				Context_listView = (ListView) findViewById(R.id.Context_listView);
				Context_listView.setAdapter(context);

				Log.v(TAG, "joey Context_listView 重製");
			}
		});

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.custom, menu);
		provider = new DynamicShareActionProvider(this);
		provider = (DynamicShareActionProvider) MenuItemCompat
				.getActionProvider(menu.findItem(R.id.menu_item_share));
		provider.setShareDataType("text/plain");
		provider.setOnShareIntentUpdateListener(new DynamicShareActionProvider.OnShareIntentUpdateListener() {
			// 分享的內容
			@Override
			public Bundle onShareIntentExtrasUpdate() {
				Bundle extras = new Bundle();
				TextView shareEdit = (TextView) findViewById(R.id.context_View1);
				extras.putString(android.content.Intent.EXTRA_TEXT, shareEdit
						.getText().toString());
				return extras;
			}

		});

		DynamicShareActionProvider shareLaterProvider = (DynamicShareActionProvider) MenuItemCompat
				.getActionProvider(menu.findItem(R.id.menu_item_share_later));
		shareLaterProvider.setShareDataType("text/plain");
		shareLaterProvider
				.setOnShareLaterListener(new DynamicShareActionProvider.OnShareLaterListener() {

					@Override
					public void onShareClick(Intent shareIntent) {

						MyShareAsyncTask task = new MyShareAsyncTask();
						task.execute(shareIntent);
					}

				});

		return true;
	}

	private class MyShareAsyncTask extends AsyncTask<Intent, Void, Intent> {

		@Override
		protected void onPreExecute() {

			Toast.makeText(ContextA.this, R.string.asynctask, Toast.LENGTH_LONG)
					.show();
		}

		@Override
		protected Intent doInBackground(Intent... intents) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 想要分享的內容位置
			TextView shareEdit = (TextView) findViewById(R.id.context_View1);
			intents[0].putExtra(android.content.Intent.EXTRA_TEXT,
					"Shared from an AsyncTask: "
							+ shareEdit.getText().toString());

			return intents[0];
		}

		@Override
		protected void onPostExecute(Intent intent) {
			startActivity(intent);
		}

	}

}
