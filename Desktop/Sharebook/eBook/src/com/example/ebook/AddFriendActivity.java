package com.example.ebook;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import manager.Find_Friend_School;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import baseclass.DB_user;

public class AddFriendActivity extends Activity{

	private String[] schools = new String[] {"Sun Yat-Sen University", "Southwest University", "Southeast University", "Shandong University",
			"Guangzhou University", "Guangxi University", "Guizhou University", "中山大学", "中国地质大学", "中国农业大学"};
	private AutoCompleteTextView auto;
	private Button goSearch;
	private Button addinfoBtn;
	private GetNewsReceiver receiver=null;
	
	private ListView searchList;
	private List<Map<String, Object>> searchDataList = new ArrayList<Map<String, Object>>();
	private Find_Friend_School find_friend_school;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addfriend);
		
		auto = (AutoCompleteTextView) findViewById(R.id.schoolname);
		
		//创建一个ArrayAdapter封装存有学校名字的数组
		ArrayAdapter<String> schoolsAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, schools);
		auto.setAdapter(schoolsAdapter);
		auto.setThreshold(1);
		goSearch = (Button) findViewById(R.id.search);
		searchList = (ListView) findViewById(R.id.searchedfriends);
		//点击搜索按钮出结果
		goSearch.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				GetDataTask test=new GetDataTask();
				test.execute();
			}
			
		});
		
		addinfoBtn = (Button) findViewById(R.id.addinfo);
		addinfoBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(AddFriendActivity.this, AddInfoActivity.class);
				startActivity(intent);
			}
			
		});
		
	}
	
	private class GetDataTask extends AsyncTask<Void, Void, List<DB_user>> {

        @Override
        protected List<DB_user> doInBackground(Void... params) {
            // Simulates a background job.
        	find_friend_school=new Find_Friend_School();        	
        	List<DB_user> data=new ArrayList<DB_user>();
        	publishProgress();
			try {
				data = find_friend_school.run(URLEncoder.encode(auto.getText().toString(),"utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return data;
			}
            return data;
        }
        @Override  
        protected void onProgressUpdate(Void... params) {  
        	Toast.makeText(AddFriendActivity.this,"努力加载中请稍等", Toast.LENGTH_SHORT).show();
        }  
        @Override
        protected void onPostExecute(List<DB_user> result) {   
        	
        	int count=result.size();
        	Map<String, Object> map;
        	searchDataList.clear();
        	while(count>0)
        	{
        		map=new HashMap<String,Object>();
        		map.put("img", R.drawable.head01);
        		map.put("name", result.get(count-1).getNickname());
        		map.put("book", "藏书："+result.get(count-1).getOwnbook());
        		map.put("intro","简介："+result.get(count-1).getMark());
        		searchDataList.add(map);
        		count--;
        	}
        	SimpleAdapter listItemAdapter = new SimpleAdapter(AddFriendActivity.this,
					searchDataList,
					R.layout.searchfriendlist_item,
					new String[] {"img", "name", "book", "intro"},
					new int[] {R.id.searchimgid, R.id.searchednameid, R.id.searchedbookid, R.id.searchedintroid});
			searchList.setAdapter(listItemAdapter);
            super.onPostExecute(result);
        }
    }
	
	public class GetNewsReceiver extends BroadcastReceiver {
    	@Override
    	public void onReceive(Context context, Intent intent) {
    		Bundle bundle=intent.getExtras();
    		//ArrayList<String> data=bundle.getStringArrayList("data");  
    	}
	}
}
