package com.example.webview;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	private String url="http://2014.qq.com/";
	private WebView webView;
	private ProgressDialog dialog;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		init();
		
	}
	
	private void init(){
		webView=(WebView) findViewById(R.id.webView);
		//webView.loadUrl("file:///android_asset/hao123.html");
		
		webView.loadUrl("http://www.baidu.com");
		
		webView.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				view.loadUrl(url);
				
				return true;
			}
		});
		
		webView.setWebChromeClient(new WebChromeClient(){
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				if(newProgress==100){
					closeDialog();
				}else{
					openDialog(newProgress);
				}
				
				
			}

			private void closeDialog() {
				// TODO Auto-generated method stub
				if(dialog!=null&&dialog.isShowing()){
					dialog.dismiss();
					dialog=null;
				}
			}

			private void openDialog(int newProgress) {
				// TODO Auto-generated method stub
				if(dialog==null){
					dialog=new ProgressDialog(MainActivity.this);
					dialog.setTitle("LOADING");
					dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
					dialog.setProgress(newProgress);
					dialog.show();
					
				}else{
					dialog.setProgress(newProgress);
				}
			}
			
		});
		
		
		
		WebSettings settings=webView.getSettings();
		settings.setJavaScriptEnabled(true);
		settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if(keyCode==KeyEvent.KEYCODE_BACK){
			if(webView.canGoBack()){
				webView.goBack();
				return true;
				
			}else{
				System.exit(0);
			}
			
		}
		
		
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
