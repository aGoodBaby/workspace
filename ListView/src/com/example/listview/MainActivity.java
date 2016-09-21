package com.example.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener,OnScrollListener {
	
	private ListView listView;
	private ArrayAdapter<String> arr_adapter;
	private SimpleAdapter simp_adapter;
	private List<Map<String,Object>> dataList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String[] res={"1","2","3","4","5","6","7","8","9","10"};
		
		listView=(ListView) findViewById(R.id.listView1);
		arr_adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,res);
		
		dataList=new ArrayList<Map<String,Object>>();
		
		simp_adapter=new SimpleAdapter(this,getdata(),R.layout.item,new String[]{"pic","text"},new int[]{R.id.imageView1,R.id.textView1});
		
		listView.setAdapter(simp_adapter);
		listView.setOnItemClickListener(this);
		listView.setOnScrollListener(this);
	}
	
	private List<Map<String,Object>> getdata(){
		for(int i=0;i<10;i++){
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("pic", R.drawable.ic_launcher);
			map.put("text", i+"");
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

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "sb", Toast.LENGTH_SHORT).show();
	}

}
