package com.mombaby.MombabyPod.context;

import android.app.ProgressDialog;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class InsideWebViewClient extends WebViewClient {
	ProgressDialog dialog = null;
	Context_Web context_Web;
	String TAG = "InsideWebViewClient";
	
	public InsideWebViewClient(Context_Web Web,ProgressDialog log ){
		context_Web = Web;
		dialog = log;
	}
	
	@Override  
    public void onPageFinished(WebView view,String url)  
    {  Log.v(TAG,"joey onPageFinished url :"+url);
        dialog.dismiss();  
    } 
	
	
	@Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
		Log.v(TAG,"joey shouldOverrideUrlLoading url :"+url);
        view.loadUrl(url);
        dialog = ProgressDialog.show(context_Web,null,"讀取中..");  
        view.reload();  
        return true;
    }

}
