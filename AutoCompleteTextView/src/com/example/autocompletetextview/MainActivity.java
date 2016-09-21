package com.example.autocompletetextview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends Activity {
	
	private AutoCompleteTextView acTextView;
	private MultiAutoCompleteTextView macTextView;
	private String[] res={"beijing1","beijing2","beijing3","shanghai1","shanghai2"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		acTextView=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,res);
		acTextView.setAdapter(adapter);
		
		macTextView=(MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);
		macTextView.setAdapter(adapter);
		macTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
