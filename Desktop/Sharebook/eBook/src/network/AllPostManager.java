package network;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import receivemanager.GetMynews;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import baseclass.DB_user;

public class AllPostManager extends Service{
	
	GetMynews getmynews;
	Bundle bundle;
	List<DB_user> data;
	ArrayList<String> datas;
	
	@Override
	public void onCreate(){
		super.onCreate();
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int onStartCommand(Intent intent,int flags,int startId){
		
		bundle = intent.getExtras();	
		switch(bundle.getString("key").charAt(0))
		{
			case '0': 	data=new ArrayList<DB_user>();
						datas=new ArrayList<String>();
			 			getmynews=new GetMynews();
			 			try {
			 				data=getmynews.run(URLEncoder.encode(bundle.getString("school"),"utf-8"));
			 			} catch (UnsupportedEncodingException e) {
			 				e.printStackTrace();
			 			}
			 			
			 			int count=data.size();
			 			Intent intent1=new Intent();
			 			Bundle bundle1 =new Bundle();
			 			Log.i("alltest",data.get(count-1).getNickname());
			 			while(count>0)
			 			{
			 				datas.add(data.get(count-1).getNickname());
			 				datas.add(data.get(count-1).getMark());
			 				datas.add(Integer.toString(data.get(count-1).getOwnbook()));
			 				count--;
			 			}			 			
			 			bundle1.putStringArrayList("data", datas);
			 			intent1.setAction("GetMynews");
			 			intent1.putExtras(bundle1);
			 			
			 			sendBroadcast(intent1);
			 			break;
			 			
			default: 	break;
		  		  
		}
		return START_REDELIVER_INTENT;
		
	}
	@Override
	 public void onDestroy() {
		super.onDestroy();
	 }
}

