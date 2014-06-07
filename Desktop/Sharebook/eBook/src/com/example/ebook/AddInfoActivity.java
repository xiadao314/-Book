package com.example.ebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class AddInfoActivity extends Activity{

	private ListView infoList;
	private List<Map<String, Object>> infoDataList = new ArrayList<Map<String, Object>>();
	private void setData(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.head01);
		map.put("name", "张小明 已 ");
		map.put("book", "藏书：16");
		map.put("intro", "简介：新人一枚请多指教");
		infoDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.head01);
		map.put("name", "周阳");
		map.put("book", "藏书：16");
		map.put("intro", "简介：新人一枚请多指教");
		infoDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.head01);
		map.put("name", "周阳");
		map.put("book", "藏书：16");
		map.put("intro", "简介：新人一枚请多指教");
		infoDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.head01);
		map.put("name", "周阳");
		map.put("book", "藏书：16");
		map.put("intro", "简介：新人一枚请多指教");
		infoDataList.add(map);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addinfo);
		
		
	}
}
