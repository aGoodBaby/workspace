package com.example.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity4 extends Activity {

	private EditText editText;
	
	private Button send;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main4);
		
		editText=(EditText) findViewById(R.id.editText);
		send=(Button) findViewById(R.id.send);
		
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String text=editText.getText().toString();
			}
		});
	}
	
}
