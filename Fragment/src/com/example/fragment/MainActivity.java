package com.example.fragment;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.view.Menu;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity implements OnCheckedChangeListener {
	
	private RadioGroup group;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		group=(RadioGroup) findViewById(R.id.radiogroup);
		group.setOnCheckedChangeListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@SuppressLint("NewApi")
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch(checkedId){
		case R.id.first:{
			Intent intent=new Intent(this,MainActivity2.class);
			startActivity(intent);
		}
			
			break;
		case R.id.second:{
			MyFragment2 fragment2=new MyFragment2();
			FragmentManager fragmentManager=getFragmentManager();
			FragmentTransaction beginTransaction=fragmentManager.beginTransaction();
			beginTransaction.add(R.id.frame, fragment2);
			beginTransaction.addToBackStack(null);
			beginTransaction.commit();
			
		}
			
			break;
		case R.id.third:{
			
		}
			
			break;
		case R.id.fourth:{
			
			Intent intent=new Intent(this,MainActivity4.class);
			startActivity(intent);
			
		}
			
			break;
		
		}
		
		
	}

}
