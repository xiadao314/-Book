package com.example.ebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class AddInfoActivity extends Activity{

	private ListView noteList;
	private List<Map<String, Object>> noteDataList = new ArrayList<Map<String, Object>>();
	private void setData(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.addinfo_borrow);
		map.put("name", "借到的书");
		noteDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.addinfo_friendadd);
		map.put("name", "好友请求 ");
		noteDataList.add(map);

		map=new HashMap<String,Object>();
		map.put("img", R.drawable.addinfo_friendrecommend);
		map.put("name", "好友推荐");
		noteDataList.add(map);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addinfo);
		
		setData();
		
		noteList = (ListView) findViewById(R.id.notelist);
		SimpleAdapter listItemAdapter = new SimpleAdapter(this,
				noteDataList,
				R.layout.notelist_item,
				new String[] {"img", "name"},
				new int[] {R.id.groupimg, R.id.groupname});
		noteList.setAdapter(listItemAdapter);
	}
}
