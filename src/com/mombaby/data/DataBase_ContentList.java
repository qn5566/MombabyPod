package com.mombaby.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.mombaby.MombabyPod.MainActivity;

public class DataBase_ContentList extends AsyncTask<String, Void, Void> {

	public  ArrayList<String> TitleList = new ArrayList<String>();
//	public ArrayList<CharSequence> activityList = new ArrayList<CharSequence>();
	ArrayList<JSONArray> activityInfoList = new ArrayList<JSONArray>();
	String TAG = "JsonObject";
	MainActivity context;

	public DataBase_ContentList(MainActivity ctx, ArrayList<String> aList) {
		context = ctx;
		this.TitleList = aList;
	}


	@Override
	protected Void doInBackground(String... params) {
		{
			Log.v(TAG, "joey go json");
			String result = "";
			try {
				URL url = new URL("http://mpod.elaiis.com/mda/subclasslist.php"+params[0]);
				Log.v(TAG, "joey go json : "+ url);
				HttpURLConnection urlConn = (HttpURLConnection) url
						.openConnection();
				if (urlConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(urlConn.getInputStream(),
									"UTF-8"));
					String str;
					// 讀一行一行讀到沒有
					while ((str = reader.readLine()) != null) {
						result = result + str;
					}
					// 把舊的清掉 讓新的讀進去
					this.TitleList.clear();
					// activityInfoList.clear();

					JSONArray jsonActs = new JSONArray(result);

					for (int i = 0; i < jsonActs.length(); i++) {
						this.TitleList.add(jsonActs.getJSONObject(i).getString(
								"name"));
						// activityInfoList.add(jsonActs.getJSONObject(i).getJSONArray("showInfo"));

					}

					context.TopTitle();
					Log.v(TAG,"joey activityList.size() : "+this.TitleList.size());
					// 執行完之後要關閉
					reader.close();

				}
				// 執行完後要關閉,以免一直連接浪費網路資源
				urlConn.disconnect();

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				e.printStackTrace();
			}

			return null;
		}
	}

}
