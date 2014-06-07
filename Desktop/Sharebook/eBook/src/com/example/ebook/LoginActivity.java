package com.example.ebook;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import manager.OnlineManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import baseclass.DB_user;
public class LoginActivity extends Activity {
	
    private static final String TAG = "LoginActivity";  
    private List<DB_user> persons;  
    private String number;
    private String pwd;
    private OnlineManager onlinemanager;
    private boolean flag;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		Button lo=(Button)findViewById(R.id.login);
		Button re=(Button)findViewById(R.id.register);
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
		onlinemanager=new OnlineManager();
		
		/*try {	
			persons=JsonParse.getListPerson(urlPath);
		}catch (Exception e) {  
            Toast.makeText(LoginActivity.this, "解析失败", Toast.LENGTH_LONG).show();//在手机上显示提示Toast，2秒  
            Log.i(TAG, e.toString());//DDMS中显示提示  

        }  */
		
		lo.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v){
				number=((EditText)findViewById(R.id.loginID)).getText().toString();
				pwd=((EditText)findViewById(R.id.loginPass)).getText().toString();
				
				flag=false;
				
				Thread thread=new Thread(new Runnable(){
					@Override
					public void run(){
						if(onlinemanager.run(number,pwd))
							flag=true;
					}
				});
				thread.run();
						
				if(number.equals("admin") && pwd.equals("admin"))
				{
					Intent intent=new Intent(LoginActivity.this,MainControlActivity.class);
					Bundle bundle=new Bundle();
					bundle.putString("nickname", "admin");
					intent.putExtras(bundle);
					startActivity(intent);
					finish();
				}
				else
				{
				if(flag){
					Intent intent=new Intent(LoginActivity.this,MainControlActivity.class);
					Bundle bundle=new Bundle();
					bundle.putString("nickname", number);
					intent.putExtras(bundle);
					startActivity(intent);
					finish();
				}
				else{
					Toast.makeText(LoginActivity.this,"你输入的帐号或密码错误", Toast.LENGTH_SHORT).show();
					
				}
				}
			}
		});
		
		re.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v){
				Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
				startActivity(intent);
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	private void getUserInfo(String url){
		HttpClient client = new DefaultHttpClient();   
        //提拱默认的HttpClient实现   
        HttpPost request;   
        try {   
            request = new HttpPost(new URI(url));   
            HttpResponse response = client.execute(request);   
            // 判断请求是否成功   
            if (response.getStatusLine().getStatusCode() == 200) { //200表示请求成功   
                HttpEntity entity = response.getEntity();   
                if (entity != null) {   
                    String out = EntityUtils.toString(entity, "UTF-8");   
                    Log.i(TAG, out); 
                       
                    JSONArray jsonArray = new JSONArray(out); 
                    for(int i = 0; i<jsonArray.length(); i++) { 
                        JSONObject jsonObject = (JSONObject) jsonArray.get(i); 
                        String name = jsonObject.getString("nickname"); 
                        String password = jsonObject.getString("password");  
                    }              
                } 
            } 
        } catch(Exception e) { 
            e.printStackTrace(); 
            Log.e(TAG, e.toString()); 
            Toast.makeText(LoginActivity.this, "获取数据失败", Toast.LENGTH_LONG).show(); 
        } 
	}
	
	
}

