package com.example.androidactivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AnotherAty extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_another_aty);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.another_aty, menu);
		return true;
	}

}
