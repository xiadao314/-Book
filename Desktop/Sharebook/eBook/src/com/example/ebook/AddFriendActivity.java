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
			"Guangzhou University", "Guangxi University", "Guizhou University", "��ɽ��ѧ", "�й����ʴ�ѧ", "�й�ũҵ��ѧ"};
	private AutoCompleteTextView auto;
	private Button goSearch;
	private Button addinfoBtn;
	
	private ListView searchList;
	private List<Map<String, Object>> searchDataList = new ArrayList<Map<String, Object>>();
	private void setData(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.head01);
		map.put("name", "��С��");
		map.put("book", "���飺23");
		map.put("intro", "��飺����˧�������ң�");
		searchDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.head01);
		map.put("name", "��С��");
		map.put("book", "���飺56");
		map.put("intro", "��飺һ���Ȱ������С����");
		searchDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.head01);
		map.put("name", "������");
		map.put("book", "���飺31");
		map.put("intro", "��飺ϣ���ܺʹ��һ���������");
		searchDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.head01);
		map.put("name", "����");
		map.put("book", "���飺16");
		map.put("intro", "��飺����һö���ָ��");
		searchDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.head01);
		map.put("name", "��С��");
		map.put("book", "���飺24");
		map.put("intro", "��飺���������ɺ�");
		searchDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.head01);
		map.put("name", "����");
		map.put("book", "���飺23");
		map.put("intro", "��飺��");
		searchDataList.add(map);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addfriend);
		
		auto = (AutoCompleteTextView) findViewById(R.id.schoolname);
		//����һ��ArrayAdapter��װ����ѧУ���ֵ�����
		ArrayAdapter<String> schoolsAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, schools);
		auto.setAdapter(schoolsAdapter);
		auto.setThreshold(1);
		
		setData();
		goSearch = (Button) findViewById(R.id.search);
		searchList = (ListView) findViewById(R.id.searchedfriends);
		//���������ť�����
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
