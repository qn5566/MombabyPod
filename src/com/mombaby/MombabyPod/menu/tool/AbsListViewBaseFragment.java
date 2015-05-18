package com.mombaby.MombabyPod.menu.tool;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;

import com.mombaby.MombabyPod.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.PauseOnScrollListener;
import com.mombaby.MombabyPod.MainActivity;
import com.mombaby.MombabyPod.context.ContextA;

public class AbsListViewBaseFragment extends BaseFragment {

	protected static final String STATE_PAUSE_ON_SCROLL = "STATE_PAUSE_ON_SCROLL";
	protected static final String STATE_PAUSE_ON_FLING = "STATE_PAUSE_ON_FLING";

	protected ListView Custom_listView;
	protected AbsListView listView;
	protected GridViewWithHeaderAndFooter GridView;

	protected boolean pauseOnScroll = false;
	protected boolean pauseOnFling = true;

	@Override
	public void onResume() {
		super.onResume();
		applyScrollListener();
	}

	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		MenuItem pauseOnScrollItem = menu.findItem(R.id.item_pause_on_scroll);
		pauseOnScrollItem.setVisible(true);
		pauseOnScrollItem.setChecked(pauseOnScroll);

		MenuItem pauseOnFlingItem = menu.findItem(R.id.item_pause_on_fling);
		pauseOnFlingItem.setVisible(true);
		pauseOnFlingItem.setChecked(pauseOnFling);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.item_pause_on_scroll:
			pauseOnScroll = !pauseOnScroll;
			item.setChecked(pauseOnScroll);
			applyScrollListener();
			return true;
		case R.id.item_pause_on_fling:
			pauseOnFling = !pauseOnFling;
			item.setChecked(pauseOnFling);
			applyScrollListener();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	//主要傳送資料的地方
	protected void startImagePagerActivity(int position) {
		Intent intent = new Intent(getActivity(), ContextA.class);
		Bundle mBundle = new Bundle();
		mBundle.putSerializable("Data", position);
		intent.putExtras(mBundle);
		startActivity(intent);
	}

	private void applyScrollListener() {
		if (listView != null) {
			listView.setOnScrollListener(new PauseOnScrollListener(ImageLoader
					.getInstance(), pauseOnScroll, pauseOnFling));
		} else if(GridView != null){
			GridView.setOnScrollListener(new PauseOnScrollListener(ImageLoader
					.getInstance(), pauseOnScroll, pauseOnFling));
		}else 
			Custom_listView.setOnScrollListener(new PauseOnScrollListener(ImageLoader
					.getInstance(), pauseOnScroll, pauseOnFling));
	}
}
