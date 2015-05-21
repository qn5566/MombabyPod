package com.mombaby.MombabyPod.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mombaby.MombabyPod.system.SystemApplication;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.mombaby.MombabyPod.MainActivity;
import com.mombaby.MombabyPod.context.ContextA;
<<<<<<< HEAD
import com.mombaby.MombabyPod.context.Context_Web;
=======
>>>>>>> origin/master

public class DataBase_ContentList extends AsyncTask<String, Void, Void> {

	String TAG = "JsonObject_DataBase";
	MainActivity MainContext;
	ContextA CtxA;
<<<<<<< HEAD
	Context_Web Ctx_webA;
=======
>>>>>>> origin/master
	ArrayList<String> Context_article = new ArrayList<String>();
	ArrayList<String> Context_content = new ArrayList<String>();

	public DataBase_ContentList(MainActivity ctx , ContextA ctxA) {
		MainContext = ctx;
		CtxA = ctxA;
	}

	public DataBase_ContentList(ContextA ctxA) {
		CtxA = ctxA;
	}
<<<<<<< HEAD
	public DataBase_ContentList(Context_Web ctxa) {
		Ctx_webA = ctxa;
	}
=======
>>>>>>> origin/master
	
	@Override
	protected Void doInBackground(String... params) {
		{
			Log.v(TAG, "joey go json 1");
			String result = "";
			try {
<<<<<<< HEAD
				// 原本的"http://mpod.elaiis.com/mda/article.php?token="
				URL url = new URL(
						"http://mpod.elaiis.com/mda/html/article.php?token="
=======
				URL url = new URL(
						"http://mpod.elaiis.com/mda/article.php?token="
>>>>>>> origin/master
								+ params[0]);
				Log.v(TAG, "joey go json : 2 " + url);
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
					Log.v(TAG, "joey go json : 3  .clear()" );
					// 把舊的清掉 讓新的讀進去
					SystemApplication.Context_brief.clear();
					SystemApplication.Context_desp.clear();
					
					Log.v(TAG, "joey go json : 4  .clear()" );
					
					JSONObject jsonObject = new JSONObject(result);

					// 直接讀取
					SystemApplication.Context_title
							.add(new JSONObject(jsonObject.getString("article"))
									.getString("title"));
					//內容Array
					JSONArray jsonArray = new JSONArray(jsonObject.getString("content"));
					//Context_content.add(jsonObject.getString("content"));
					
					for (int i = 0; i < jsonArray.length(); i++) {
						if(!jsonArray.getJSONObject(i).getString("brief").equals("")){
						SystemApplication.Context_brief.add(jsonArray
								.getJSONObject(i).getString("brief"));
						}
						if(!jsonArray.getJSONObject(i).getString("desp").equals("")){
						SystemApplication.Context_desp.add(jsonArray
								.getJSONObject(i).getString("desp"));
						}
					}
					
					Log.v(TAG, "joey Context_title.size() : "
							+ SystemApplication.Context_title.size());
					Log.v(TAG, "joey Context_brief.size() : "
							+ SystemApplication.Context_brief.size());
<<<<<<< HEAD
				//	Ctx_webA.initContextText();
					Log.v(TAG, "joey go json : 3 Ctx_webA.JoeyOK(); " );
=======
					CtxA.initContextText();
					Log.v(TAG, "joey go json : 3 CtxA.JoeyOK(); " );
>>>>>>> origin/master
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


	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);	
//		Log.v(TAG,"joey onPostExecute 1");
////		if(SystemApplication.Context_Change){
//		
//			CtxA.initContextText();
////			MainContext.ContextA_Reflesh();
////			}
//		Log.v(TAG,"joey onPostExecute 2");
////		SystemApplication.Context_Change = true;
//		Log.v(TAG,"joey onPostExecute 3 SystemApplication.Context_Change :"+SystemApplication.Context_Change);
	}
	
	
	
	
	
}
