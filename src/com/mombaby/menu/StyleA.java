package com.mombaby.menu;

import android.app.Fragment;
import android.content.Context;
import com.mombaby.context.ContextA;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.AdapterView;
import com.mombaby.menu.tool.ImageAndTextForContent;
import com.mombaby.system.SystemApplication;
import com.mombaby.MombabyPod.MainActivity;
import com.mombaby.MombabyPod.R;
import com.mombaby.menu.tool.ImageAdapter;


public class StyleA extends Fragment implements
		AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
	private ListView Content_list;
	private String[] ContentTitle;
	Context ctx;
	ImageAndTextForContent ImageAndTextAdapter ; 
	private TypedArray icons;
	String TAG ="StyleA";
	MainActivity main;

	public StyleA (){
		
	}
	
	public StyleA (MainActivity Main){
		main = Main ;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.v(TAG,"joey StyleA : onCreate");
		SystemApplication.StyleA = true;
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		this.ctx = getActivity();
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
		View view = inflater.inflate(R.layout.style_a, container, false);
		Content_list = (ListView) view.findViewById(R.id.listView_a);
		this.icons = ctx.getResources().obtainTypedArray(
				R.array.contentimagearray);

		Data_StyleA();
		return view;
	}

	public void Data_StyleA() {
		//SystemApplication.ArticleList_pic
		
		ImageAndTextAdapter = new ImageAndTextForContent(ctx,
				R.layout.content_list, SystemApplication.ArticleList_title,
				SystemApplication.ArticleList_pic);
		//R.layout.content_list = pic //  this.icons
		Log.v(TAG, "joey PIC Data_StyleA()" +SystemApplication.ArticleList_pic);
		Content_list.setAdapter(ImageAndTextAdapter);
		
		//Content_list.setAdapter(new ImageAdapter(getActivity(),SystemApplication.ArticleList_pic));
		Content_list.setOnItemClickListener(this);
	}

	public void ok(){
		ImageAndTextAdapter = new ImageAndTextForContent(main,
				R.layout.content_list, SystemApplication.ArticleList_title,
				SystemApplication.ArticleList_pic);
		// this.icons
		ImageAndTextAdapter.refresh(SystemApplication.ArticleList_title);
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent = new Intent(getActivity(), ContextA.class);
		// // key vold json接的都是String
		// intent.putExtra("act",activityInfoList.get(position).toString());
		//
		getActivity().startActivity(intent);
		//
		// Toast.makeText(getActivity(),
		// "You CLick List", Toast.LENGTH_SHORT).show();

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
