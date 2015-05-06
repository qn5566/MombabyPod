package com.mombaby.menu;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.mombaby.MombabyPod.MainActivity;
import com.mombaby.MombabyPod.R;
import com.mombaby.context.ContextA;
import com.mombaby.system.SystemApplication;

public class StyleC extends Fragment implements
AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener{
	MainActivity main;
	String TAG = "StyleC";
	
	public StyleC(){
		
	}
	
	public StyleC(MainActivity Main){
		main = Main ;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.v(TAG,"joey StyleA : onCreate");
		SystemApplication.StyleC = true;
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return initView(inflater, container);
	}

	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.style_c, container, false);
		GridView gridview = (GridView) view.findViewById(R.id.gridview);

		// 生成动态数组，并且转入数据
		ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 10; i++) {

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("ItemImage", R.drawable.content_1);// 添加图像资源的ID
			map.put("ItemText", "NO." + String.valueOf(i));// 按序号做ItemText
			lstImageItem.add(map);
		}
		// 生成适配器的ImageItem <====> 动态数组的元素，两者一一对应
		SimpleAdapter saImageItems = new SimpleAdapter(getActivity(), // 没什么解释
				lstImageItem,// 数据来源
				R.layout.night_item,// night_item的XML实现

				// 动态数组与ImageItem对应的子项
				new String[] { "ItemImage", "ItemText" },

				// ImageItem的XML文件里面的一个ImageView,两个TextView ID
				new int[] { R.id.content_c, R.id.content_up_c });
		// 添加并且显示
		gridview.setAdapter(saImageItems);
		// 添加消息处理
		gridview.setOnItemClickListener(this);

		return view;
	}

//	// 当AdapterView被单击(触摸屏或者键盘)，则返回的Item单击事件
//	class ItemClickListener implements OnItemClickListener {
//		public void onItemClick(AdapterView<?> arg0,// The AdapterView where the
//													// click happened
//				View arg1,// The view within the AdapterView that was clicked
//				int arg2,// The position of the view in the adapter
//				long arg3// The row id of the item that was clicked
//		) {
//			// 在本例中arg2=arg3
//			HashMap<String, Object> item = (HashMap<String, Object>) arg0
//					.getItemAtPosition(arg2);
//			// 显示所选Item的ItemText
//			// setTitle((String) item.get("ItemText"));
//		}
//
//	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		 Intent intent=new Intent(getActivity(),ContextA.class);
//	        //              key   vold                       json接的都是String
//	        intent.putExtra("act",activityInfoList.get(position).toString());
//
	        getActivity().startActivity(intent);
//
//	        Toast.makeText(getActivity(),
//	                "You CLick List", Toast.LENGTH_SHORT).show();
			
		
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}

}
