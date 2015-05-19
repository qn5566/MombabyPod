package com.mombaby.MombabyPod.context;

import android.app.ProgressDialog;
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
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.mombaby.MombabyPod.system.SystemApplication;
import com.mombaby.MombabyPod.data.DataBase_ContentList;

import com.mombaby.MombabyPod.tool.DynamicShareActionProvider;
import com.mombaby.MombabyPod.R;

public class Context_Web extends ActionBarActivity{
	String TAG= "Context_Web";
	DataBase_ContentList ContentData;
	DynamicShareActionProvider provider;
	WebView mWebView01;
	String URL = "http://mpod.elaiis.com/mda/html/article.php?token=";
	ProgressDialog dialog = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.context_web);
		
		mWebView01 = (WebView) findViewById(R.id.context_webview);
		InterData(mWebView01);
        
	}
	
	// 接受傳值的方法
	public void InterData(WebView mWebView01){
		int dataInt = (Integer) getIntent().getSerializableExtra("Data");
		Log.v(TAG, "joey InterData : " + dataInt);
		//DataBase_(dataInt);		
		mWebView01.getSettings().setJavaScriptEnabled(true);
		dialog = ProgressDialog.show(this,null,"讀取中..");  
		mWebView01.setWebViewClient(new InsideWebViewClient(this,dialog));  
		mWebView01.loadUrl(URL+SystemApplication.ArticleList_rkey.get(dataInt));
		//重新整理
		//mWebView01.reload();  		
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
		mWebView01 = null;
		Log.v(TAG, "joey mWebView01 = null;" );
		super.onDestroy();
	}

	@Override
	protected void onRestart() {
		Log.v(TAG,"joey onRestart()");
		super.onRestart();
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

			Toast.makeText(Context_Web.this, R.string.asynctask, Toast.LENGTH_LONG)
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
