package com.example.scorllview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv;
	
	private ScrollView scroll;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		tv=(TextView) findViewById(R.id.content);
		tv.setText(getResources().getString(R.string.content));
		
		scroll=(ScrollView) findViewById(R.id.scroll);
		
		scroll.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch(event.getAction()){
				case MotionEvent.ACTION_MOVE:
				{
					if(scroll.getChildAt(0).getMeasuredHeight()<=scroll.getHeight()+scroll.getScrollY()){
						tv.append(getResources().getString(R.string.content));
					}
					
					break;
				}
				
				}
				
				
				return false;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
