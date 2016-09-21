package com.example.progressbar;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private ProgressBar progress;
	private Button add;
	private Button reduce;
	private Button reset;
	private TextView text;
	private ProgressDialog prodialog;
	private Button show;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_PROGRESS);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		
		setContentView(R.layout.main);
		
		setProgressBarVisibility(true);
		setProgressBarIndeterminateVisibility(true);
		
		setProgress(8888);
		
		init();
		
	}
	
	private void init(){
		progress=(ProgressBar) findViewById(R.id.horiz);
		add=(Button) findViewById(R.id.add);
		reduce=(Button) findViewById(R.id.reduce);
		reset=(Button) findViewById(R.id.reset);
		text=(TextView) findViewById(R.id.text);
		show=(Button)findViewById(R.id.show);
		
		int first =progress.getProgress();
		int second = progress.getSecondaryProgress();
		int max=progress.getMax();
		
		text.setText("第一进度条"+(int)(first/(float)max*100)+"%，第二进度条"+(int)(second/(float)max*100)+"%");
		
		add.setOnClickListener(this);
		reduce.setOnClickListener(this);
		reset.setOnClickListener(this);
		show.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.add:{
			progress.incrementProgressBy(10);
			progress.incrementSecondaryProgressBy(10);
			
			break;
		}
		case R.id.reduce:{

			progress.incrementProgressBy(-10);
			progress.incrementSecondaryProgressBy(-10);
			
			break;
		}
		case R.id.reset:{
			progress.setProgress(50);
			progress.setSecondaryProgress(80);
			
			break;
		}
		case R.id.show:{
			prodialog=new ProgressDialog(MainActivity.this);
			prodialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			prodialog.setTitle("慕课网");
			prodialog.setMessage("欢迎大家支持慕课网");
			prodialog.setIcon(R.drawable.ic_launcher);
			
			prodialog.setMax(100);
			prodialog.incrementProgressBy(50);
			prodialog.setIndeterminate(false);
			
			prodialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Toast.makeText(MainActivity.this, "welcom", Toast.LENGTH_SHORT).show();
					
				}
			});
			prodialog.setCancelable(true);
			prodialog.show();
			break;
		}
		
		}
		text.setText("第一进度条"+(int)(progress.getProgress()/(float)progress.getMax()*100)+"%，第二进度条"+(int)(progress.getSecondaryProgress()/(float)progress.getMax()*100)+"%");
	}

}
