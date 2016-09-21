package com.example.gridview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	
	private GridView gridView;
	private List<Map<String,Object>> dataList;
	private int[]icon={
			R.drawable.address_book,R.drawable.calendar,R.drawable.camera,R.drawable.clock,R.drawable.games_control,
			R.drawable.messenger,R.drawable.ringtone,R.drawable.settings,R.drawable.speech_balloon,R.drawable.weather,R.drawable.world,
			R.drawable.youtube
	};
	private String[] iconName={
		"通讯录","日历","照相机","时钟","游戏","短信","铃声","设置","语音","天气","浏览器","视频"
	};
	private SimpleAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		gridView=(GridView) findViewById(R.id.gridView1);
		dataList=new ArrayList<Map<String,Object>>();
		
		
		adapter=new SimpleAdapter(this, getData(), R.layout.item,new String[]{"image","text"},new int[]{R.id.image,R.id.text});
		
		gridView.setAdapter(adapter);
	}
	
	private List<Map<String,Object>> getData(){
		
		for (int i = 0; i < icon.length; i++) {
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("image", icon[i]);
			map.put("text", iconName[i]);
			dataList.add(map);
		}
		
		return dataList;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
