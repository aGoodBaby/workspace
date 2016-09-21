package com.example.learnintent;

import android.app.Activity;
import android.os.Bundle;

public class MyAty extends Activity{
	
	public static final String ACTION="com.jikexueyuan.learnintent.intent.action.MyAty";
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myaty);
	}

}
