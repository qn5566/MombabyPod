package com.mombaby.menu;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mombaby.context.ContextA;
import com.mombaby.menu.tool.ImageAndTextForContent;
import com.mombaby.menu.tool.TextForContent;
import com.mombaby.system.SystemApplication;

import com.mombaby.MombabyPod.MainActivity;
import com.mombaby.MombabyPod.R;

public class StyleB extends Fragment implements
AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener{

	private ListView Content_list;
	private String[] ContentTitle;
	public Context ctx;
	public TextForContent TextAdapter ; 
	private TypedArray icons;
	public String TAG ="StyleB";
	MainActivity main;
	
	
	public StyleB() {
		// TODO Auto-generated constructor stub
	}
	public  StyleB(MainActivity Main){
		main = Main ;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.v(TAG,"joey StyleB : onCreate");
		this.ctx = getActivity();
		SystemApplication.StyleB = true;
		TextAdapter =  new TextForContent(ctx,
				R.layout.content_list2, SystemApplication.ArticleList_title );
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {		
		ContentTitle = new String[] { "Afghanistan", "Albania", "Algeria",
				"American Samoa", "Andorra", "Angola", "Anguilla",
				"Antarctica", "Antigua and Barbuda", "Argentina", "Armenia",
				"Aruba", "Australia", "Austria", "Azerbaijan", "Bahrain",
				"Bangladesh", "Barbados", "Belarus", "Belgium", "Belize",
				"Benin", "Bermuda", "Bhutan", "Bolivia",
				"Bosnia and Herzegovina", "Botswana", "Bouvet Island",
				"Albania", "Algeria", "American Samoa", "Andorra", "Angola",
				"Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina",
				"Armenia", "Aruba", "Australia", "Austria", "Azerbaijan",
				"Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium",
				"Belize", "Benin", "Bermuda", "Bhutan", "Bolivia",
				"Bosnia and Herzegovina", "Botswana", "Bouvet Island" };
		return initView(inflater, container);
	}

	
	private View initView(LayoutInflater inflater, ViewGroup container) {
		View view = inflater.inflate(R.layout.style_b, container, false);
		Content_list = (ListView) view.findViewById(R.id.listView_b);
		
//		Content_list.setAdapter(new TextForContent(ctx,
//				R.layout.content_list2,  SystemApplication.ArticleList_title ));
//		Content_list.setOnItemClickListener(this);
		Data_StyleB() ;
		
		return view;
	}
	public void Data_StyleB() {	
		
		
		Content_list.setAdapter(TextAdapter);
		Content_list.setOnItemClickListener(this);
	}
	
	public void okk(){
		TextAdapter =  new TextForContent(main,
				R.layout.content_list2, SystemApplication.ArticleList_title );
		TextAdapter.notifyDataSetChanged();
		
	}

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
