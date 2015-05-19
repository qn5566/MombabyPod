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

import android.os.AsyncTask;
import android.util.Log;
import com.mombaby.MombabyPod.MainActivity;
import com.mombaby.MombabyPod.system.SystemApplication;
import com.mombaby.MombabyPod.menu.StyleA;
import com.mombaby.MombabyPod.menu.StyleB;
import com.mombaby.MombabyPod.menu.StyleC;

public class DataBase_ArticleList extends AsyncTask<String, Void, Void> {

	
	String TAG = "DataBase_ArticleList";
	MainActivity context;
	StyleA Stylea;
	StyleB Styleb;
	StyleC Stylec;

<<<<<<< HEAD
	public DataBase_ArticleList(MainActivity ctx ,StyleA stylea, StyleB styleb, StyleC stylec) {
		context = ctx;

=======
	public DataBase_ArticleList(MainActivity ctx, ArrayList<String> title,
			ArrayList<String> rkey, ArrayList<String> brief,
			ArrayList<String> pic, StyleA stylea, StyleB styleb, StyleC stylec) {
		context = ctx;
		SystemApplication.ArticleList_title = title;
		SystemApplication.ArticleList_rkey = rkey;
		SystemApplication.ArticleList_brief = brief;
		SystemApplication.ArticleList_pic = pic;
>>>>>>> origin/master

		Stylea = stylea;
		Styleb = styleb;
		Stylec = stylec;
	}

	@Override
	protected Void doInBackground(String... params) {
		{
			Log.v(TAG, "joey go json params[0] :" + params[0]);
			String result = "";
			try {
				Log.v(TAG, "joey go 1 json");
				URL url = new URL("http://mpod.elaiis.com/mda/articlelist.php?"
						+ params[0]);
				HttpURLConnection urlConn = (HttpURLConnection) url
						.openConnection();
				Log.v(TAG, "joey go 2 json");
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
					Log.v(TAG, "joey go 3 json result :" + result);
					SystemApplication.ArticleList_title.clear();
					SystemApplication.ArticleList_rkey.clear();
					SystemApplication.ArticleList_brief.clear();
					SystemApplication.ArticleList_pic.clear();
<<<<<<< HEAD
					SystemApplication.ArticleList_short_desp.clear();
=======
>>>>>>> origin/master
					Log.v(TAG, "joey go 4 json");
					JSONArray jsonActs = new JSONArray(result);
					Log.v(TAG,
							"joey go 5 jsonActs.length() :" + jsonActs.length());
					for (int i = 0; i < jsonActs.length(); i++) {
						SystemApplication.ArticleList_title.add(jsonActs
								.getJSONObject(i).getString("title"));
						SystemApplication.ArticleList_rkey.add(jsonActs
								.getJSONObject(i).getString("rkey"));
						SystemApplication.ArticleList_brief.add(jsonActs
								.getJSONObject(i).getString("brief"));
<<<<<<< HEAD
						SystemApplication.ArticleList_short_desp.add(jsonActs
								.getJSONObject(i).getString("short_desp"));
=======
>>>>>>> origin/master
						SystemApplication.ArticleList_pic.add(
								SystemApplication.ArticleList_Pic_Path+(jsonActs
								.getJSONObject(i).getString("photo_path")));
						Log.v(TAG, "joey run json ArticleList_pic :"
								+SystemApplication.ArticleList_Pic_Path+(jsonActs
										.getJSONObject(i).getString("photo_path")));
					}
					Log.v(TAG, "joey Stylea :" + Stylea);
					if (SystemApplication.StyleA) {

						Stylea.refreshA();
<<<<<<< HEAD
						Log.v(TAG, "joey Styleb.refreshA() : OK");
=======

>>>>>>> origin/master
					}
					Log.v(TAG, "joey Styleb :" + Styleb);
					if (SystemApplication.StyleB) {

						Styleb.refreshB();
<<<<<<< HEAD
						Log.v(TAG, "joey Styleb.refreshB() : OK");
=======

>>>>>>> origin/master
					}
					if (SystemApplication.StyleC) {

						Stylec.refreshC();
<<<<<<< HEAD
						Log.v(TAG, "joey Stylec.refreshC() : OK");
					}
					Log.v(TAG, "joey 總共文章數量 : "
=======

					}
					Log.v(TAG, "joey activityList.size() : "
>>>>>>> origin/master
							+ SystemApplication.ArticleList_title.size());
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
