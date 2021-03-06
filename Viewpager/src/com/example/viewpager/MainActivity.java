package com.example.viewpager;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;

public class MainActivity extends FragmentActivity {
	
	private List<View> viewList;
	private ViewPager pager;
	private List<String> titleList;
	private List<Fragment> fragList;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		viewList=new ArrayList<View>();
		
		View view1=View.inflate(this, R.layout.view1, null);
		View view2=View.inflate(this, R.layout.view2, null);
		View view3=View.inflate(this, R.layout.view3, null);
		View view4=View.inflate(this, R.layout.view4, null);
		
		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);
		viewList.add(view4);
		
		fragList=new ArrayList<Fragment>();
		
		fragList.add(new Fragment1());
		fragList.add(new Fragment2());
		fragList.add(new Fragment3());
		fragList.add(new Fragment4());
		
		
		
		titleList=new ArrayList<String>();
		
		titleList.add("第一页");
		titleList.add("第二页");
		titleList.add("第三页");
		titleList.add("第四页");
		
		MyPagerAdapter myPagerAdapter=new MyPagerAdapter(viewList,titleList);
		
		
		
		
		
		pager=(ViewPager) findViewById(R.id.pager);
		
		//pager.setAdapter(myPagerAdapter);
		MyFragmentPagerAdapter myFragmentPagerAdapter=new MyFragmentPagerAdapter(getSupportFragmentManager(), fragList, titleList);
		pager.setAdapter(myFragmentPagerAdapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
