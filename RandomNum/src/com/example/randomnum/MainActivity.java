package com.example.randomnum;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private Button btn;
	private TextView tv;
	private boolean stop=true;
	
	private Timer mTimer;
	 
	 
	 
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn=(Button) findViewById(R.id.button1);
		tv=(TextView) findViewById(R.id.textView1);
		
		mTimer = new Timer();  
        // start timer task  
        setTimerTask(); 
        
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(stop){
					stop=false;
					btn.setText("停止");
				}else{
					stop=true;
					btn.setText("生成");
				}
			}
		});
		
		
		
	}
	
    @Override  
    protected void onDestroy() {  
        super.onDestroy();  
        // cancel timer  
        mTimer.cancel();  
    }  
	
	
	
	private void setTimerTask() {  
        mTimer.schedule(new TimerTask() {  
            @Override  
            public void run() {  
                Message message = new Message();  
                message.what = 1;  
                doActionHandler.sendMessage(message);  
            }  
        }, 1000, 300/* 表示1000毫秒之後，每隔1000毫秒執行一次 */);  
    }  
	
	
	
	private Handler doActionHandler = new Handler() {  
        @Override  
        public void handleMessage(Message msg) {  
            super.handleMessage(msg);  
            int msgId = msg.what;  
            switch (msgId) {  
                case 1:  
                    // do some action 
                	if(!stop){
                	tv.setText(""+(int)(Math.random()*100));
                	}
                    break;  
                default:  
                    break;  
            }  
        }  
    }; 
	
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
