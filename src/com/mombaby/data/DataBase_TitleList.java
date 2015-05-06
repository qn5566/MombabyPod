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

import android.os.AsyncTask;
import android.util.Log;
import com.mombaby.MombabyPod.MainActivity;
import com.mombaby.system.SystemApplication;

public class DataBase_TitleList extends AsyncTask<String, Void, Void> {

	ArrayList<JSONArray> activityInfoList = new ArrayList<JSONArray>();
	String TAG = "JsonObject";
	MainActivity context;

	public DataBase_TitleList(MainActivity ctx, ArrayList<String> aList, ArrayList<String> id_aList) {
		context = ctx;
		SystemApplication.TitleList = aList;
		SystemApplication.Title_id = id_aList;
		
	}


	@Override
	protected Void doInBackground(String... params) {
		{
			Log.v(TAG, "joey go json");
			String result = "";
			try {
				URL url = new URL("http://mpod.elaiis.com/mda/subclasslist.php");
				HttpURLConnection urlConn = (HttpURLConnection) url
						.openConnection();
				Log.v(TAG, "joey go 2 json");
				if (urlConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(urlConn.getInputStream(),
									"UTF-8"));
					Log.v(TAG, "joey go 3 json");
					String str;
					// 讀一行一行讀到沒有
					while ((str = reader.readLine()) != null) {
						result = result + str;
					}
					// 把舊的清掉 讓新的讀進去
					Log.v(TAG, "joey go 3 json result :" +result);
					SystemApplication.TitleList.clear();
					SystemApplication.Title_id.clear();
					Log.v(TAG, "joey go 4 json");
					JSONArray jsonActs = new JSONArray(result);
					Log.v(TAG, "joey go 5 jsonActs.length() :" + jsonActs.length());
					for (int i = 0; i < jsonActs.length(); i++) {
						SystemApplication.TitleList.add(jsonActs.getJSONObject(i).getString(
								"name"));
						SystemApplication.Title_id.add(jsonActs.getJSONObject(i).getString(
								"id"));
					}
					//客製化Title
					context.TopTitle();
					Log.v(TAG,"joey activityList.size() : "+SystemApplication.TitleList.size());
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
