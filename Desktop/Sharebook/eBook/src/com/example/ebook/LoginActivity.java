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
import baseclass.LoginUser;
public class LoginActivity extends Activity {
	
    private static final String TAG = "LoginActivity";  
    private List<DB_user> persons;  
    private List<LoginUser> data;
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
		data = new ArrayList<LoginUser>(); 
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
		onlinemanager=new OnlineManager();
		
		/*try {	
			persons=JsonParse.getListPerson(urlPath);
		}catch (Exception e) {  
            Toast.makeText(LoginActivity.this, "����ʧ��", Toast.LENGTH_LONG).show();//���ֻ�����ʾ��ʾToast��2��  
            Log.i(TAG, e.toString());//DDMS����ʾ��ʾ  

        }  */
		
		lo.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v){
				number=((EditText)findViewById(R.id.loginID)).getText().toString();
				pwd=((EditText)findViewById(R.id.loginPass)).getText().toString();
				String nickname="����Ա";
				Log.i("test","test");
				
				flag=false;
				
				Thread thread=new Thread(new Runnable(){
					@Override
					public void run(){
						if(onlinemanager.run(number,pwd))
							flag=true;
					}
				});
				thread.run();
				
				if(flag){
					Intent intent=new Intent(LoginActivity.this,MainControlActivity.class);
					Bundle bundle=new Bundle();
					bundle.putString("nickname", nickname);
					intent.putExtras(bundle);
					startActivity(intent);
				}
				else{
					Toast.makeText(LoginActivity.this,"��������ʺŻ��������", Toast.LENGTH_SHORT).show();
					
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
	private boolean isLogin(){
		for(int i=0;i<data.size();i++)
		{
			if(number.equals(data.get(i).getName())&&pwd.equals(data.get(i).getPwd()))
				return true;
			if(number.equals(data.get(i).getName())&&!pwd.equals(data.get(i).getPwd()))
				return false;
		}
		return false;
	}
	private void getUserInfo(String url){
		HttpClient client = new DefaultHttpClient();   
        //�ṰĬ�ϵ�HttpClientʵ��   
        HttpPost request;   
        try {   
            request = new HttpPost(new URI(url));   
            HttpResponse response = client.execute(request);   
            // �ж������Ƿ�ɹ�   
            if (response.getStatusLine().getStatusCode() == 200) { //200��ʾ����ɹ�   
                HttpEntity entity = response.getEntity();   
                if (entity != null) {   
                    String out = EntityUtils.toString(entity, "UTF-8");   
                    Log.i(TAG, out); 
                       
                    JSONArray jsonArray = new JSONArray(out); 
                    for(int i = 0; i<jsonArray.length(); i++) { 
                        JSONObject jsonObject = (JSONObject) jsonArray.get(i); 
                        String name = jsonObject.getString("nickname"); 
                        String password = jsonObject.getString("password");  
                        data.add(new LoginUser(name,password));
                    }              
                } 
            } 
        } catch(Exception e) { 
            e.printStackTrace(); 
            Log.e(TAG, e.toString()); 
            Toast.makeText(LoginActivity.this, "��ȡ����ʧ��", Toast.LENGTH_LONG).show(); 
        } 
	}
	
	
}

