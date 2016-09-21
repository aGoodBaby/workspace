package com.example.androidactivity;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		setContentView(R.layout.my_layout);
		
		findViewById(R.id.btnStartAnotherAty).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//startActivity(new Intent(MainActivity.this,AnotherAty.class));
				startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://jikexueyuan.com")));
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
