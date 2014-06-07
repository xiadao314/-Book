package com.example.ebook;

import manager.RegisterManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegisterActivity extends Activity{
	private String number;
    private String pwd,pwd1;
    private RegisterManager registermanager;
    private boolean flag;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.register);
		registermanager=new RegisterManager();
		
		Button choosehead=(Button)findViewById(R.id.choosehead);
		choosehead.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent=new Intent(RegisterActivity.this,HeadActivity.class);
				startActivityForResult(intent,0x11);
			}
		});
		
		Button maketrue=(Button)findViewById(R.id.resgisterACK);
		
		maketrue.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				number=((EditText)findViewById(R.id.registerID)).getText().toString();
				pwd=((EditText)findViewById(R.id.registerPass)).getText().toString();
				pwd1=((EditText)findViewById(R.id.registerPasstest)).getText().toString();
				
				flag=false;
				if(pwd.equals("")||pwd1.equals("")||number.equals(""))
					Toast.makeText(RegisterActivity.this,"用户名或密码不能为空", Toast.LENGTH_SHORT).show();
				else{
					if(pwd.equals(pwd1))
					{
						Thread thread=new Thread(new Runnable(){
							@Override
							public void run(){
								if(registermanager.run(number,pwd))
									flag=true;
							}
						});
						thread.run();
						if(flag){
							Toast.makeText(RegisterActivity.this,"注册成功", Toast.LENGTH_SHORT).show();
							Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
							startActivity(intent);
						}
						else{
							Toast.makeText(RegisterActivity.this,"注册失败", Toast.LENGTH_SHORT).show();	
						}
					}
					else
						Toast.makeText(RegisterActivity.this,"两次输入密码不一致", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode,int resultCode,Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==0x11&&resultCode==0x11){
			Bundle bundle=data.getExtras();
			int imageId=bundle.getInt("HeadId");
			ImageView iv=(ImageView)findViewById(R.id.registerHead);
			iv.setImageResource(imageId);
			
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
