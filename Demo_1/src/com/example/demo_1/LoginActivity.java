package com.example.demo_1;

import android.os.Bundle;
import android.os.Process;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener {
	private EditText userName;
	private EditText passWord;
	private Button enter;
	
	private InputMethodManager imm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		imm=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		
		userName=(EditText) findViewById(R.id.editText1);
		passWord=(EditText) findViewById(R.id.editText2);
		enter=(Button) findViewById(R.id.enter);
		
		enter.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		imm.hideSoftInputFromWindow(userName.getWindowToken(), 0);
		imm.hideSoftInputFromWindow(passWord.getWindowToken(), 0);
		
		
		String inputUserName=userName.getText().toString();
		String inputPassWord=passWord.getText().toString();
		if(inputUserName.trim().equals("user")&&inputPassWord.trim().equals("123")){
			Toast.makeText(LoginActivity.this, "sb", Toast.LENGTH_SHORT).show();
			
			Intent intent=new Intent(LoginActivity.this,MainActivity.class);
			
			intent.putExtra("act", "Login");
			
			Bundle bundle=new Bundle();
			bundle.putString("uname", inputUserName);
			bundle.putString("upwd", inputPassWord);
			intent.putExtra("Bundle", bundle);
			startActivity(intent);
			
			finish();
			
			overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
			
			killProcessActivity();			
		}else {
			Toast.makeText(LoginActivity.this,"用户名或密码错误" , Toast.LENGTH_SHORT).show();
			userName.setText("");
			passWord.setText("");
			
			userName.setFocusable(true);
			userName.requestFocus();
		}
	}
	private void killProcessActivity(){
		Process.killProcess(Process.myPid());
		System.exit(0);
	}

}
