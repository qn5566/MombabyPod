package com.mombaby.context;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.mombaby.system.SystemApplication;

import com.mombaby.tool.DynamicShareActionProvider;
import com.mombaby.MombabyPod.R;

public class ContextA extends ActionBarActivity {

	public ShareActionProvider mShareActionProvider;
	ListView Context_listView ;
	View mHeader;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contexta);
		LayoutInflater inflater=(LayoutInflater)getSystemService(this.LAYOUT_INFLATER_SERVICE); 
		mHeader = inflater.inflate(R.layout.header, null);
		
		Context_listView = (ListView) findViewById(R.id.Context_listView);
		
		Context_listView.addHeaderView(mHeader);
		Context_listView.setAdapter(new ContextText(this,R.layout.context_layout
				,SystemApplication.Context_brief,SystemApplication.Context_desp));

	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.custom, menu);

		DynamicShareActionProvider provider = (DynamicShareActionProvider) MenuItemCompat
				.getActionProvider(menu.findItem(R.id.menu_item_share));
		provider.setShareDataType("text/plain");
		provider.setOnShareIntentUpdateListener(new DynamicShareActionProvider.OnShareIntentUpdateListener() {
			//分享的內容
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
			//想要分享的內容位置
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
