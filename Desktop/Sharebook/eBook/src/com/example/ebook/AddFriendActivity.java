package com.example.ebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class AddFriendActivity extends Activity{

	private String[] schools = new String[] {"Sun Yat-Sen University", "Southwest University", "Southeast University", "Shandong University",
			"Guangzhou University", "Guangxi University", "Guizhou University", "中山大学", "中国地质大学", "中国农业大学"};
	private AutoCompleteTextView auto;
	private Button goSearch;
	private Button addinfoBtn;
	
	private ListView searchList;
	private List<Map<String, Object>> searchDataList = new ArrayList<Map<String, Object>>();
	private void setData(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.head01);
		map.put("name", "张小明");
		map.put("book", "藏书：23");
		map.put("intro", "简介：阳光帅气就是我！");
		searchDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.head01);
		map.put("name", "李小红");
		map.put("book", "藏书：56");
		map.put("intro", "简介：一个热爱读书的小姑娘");
		searchDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.head01);
		map.put("name", "王妮玛");
		map.put("book", "藏书：31");
		map.put("intro", "简介：希望能和大家一起多分享好书");
		searchDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.head01);
		map.put("name", "周阳");
		map.put("book", "藏书：16");
		map.put("intro", "简介：新人一枚请多指教");
		searchDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.head01);
		map.put("name", "郭小明");
		map.put("book", "藏书：24");
		map.put("intro", "简介：悲伤逆流成河");
		searchDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.head01);
		map.put("name", "韩函");
		map.put("book", "藏书：23");
		map.put("intro", "简介：萌");
		searchDataList.add(map);
	}
	
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
		
		setData();
		goSearch = (Button) findViewById(R.id.search);
		searchList = (ListView) findViewById(R.id.searchedfriends);
		//点击搜索按钮出结果
		goSearch.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				SimpleAdapter listItemAdapter = new SimpleAdapter(AddFriendActivity.this,
						searchDataList,
						R.layout.searchfriendlist_item,
						new String[] {"img", "name", "book", "intro"},
						new int[] {R.id.searchimgid, R.id.searchednameid, R.id.searchedbookid, R.id.searchedintroid});
				searchList.setAdapter(listItemAdapter);
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
}
