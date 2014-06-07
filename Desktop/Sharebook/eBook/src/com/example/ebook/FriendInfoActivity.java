/** �ں����б��е�����Ѻ����������Ѳ�����Ϣҳ��  **/
package com.example.ebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class FriendInfoActivity extends Activity{

	private TextView friendName;
	
	private ListView friendbooklistView;
	private List<Map<String,Object>> friendbookDataList=new ArrayList<Map<String,Object>>();
	
	private void setData(){
		Map<String,Object> map=new HashMap<String,Object>();

		map=new HashMap<String,Object>();
		map.put("img", R.drawable.book1);
		map.put("name", "ȫְ����");
		map.put("uploadtime", "2014-3-4");
		map.put("author", "������");
		map.put("intro", "���Ķ���֮��˭�������ҵ���ҫ������Ʈҡ֮�£�ϣ��ȴ�������𡣻��Ž���֮�У�û����ʧ�˷���������Ŀ֮ǰ���ң���������ع��ˣ�");
		friendbookDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.book2);
		map.put("name", "˭���ഺ����ã");
		map.put("uploadtime", "2014-3-1");
		map.put("author", "��ͬ");
		map.put("intro", "���Ƕ�һ��������������δ�������ѹ�ȥ������ʹ�������ӡ����Ǳ�������������������ǲ��¡����¶���������ת��������ͻȻ��˭���ഺ����ã����ʵ���Ƕ�һ����");
		friendbookDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.book3);
		map.put("name", "����õ��Լ�");
		map.put("uploadtime", "2014-2-18");
		map.put("author", "���");
		map.put("intro", "���Ȿ���������뷨���������ڹ�ȥ�����»��ź��б����ġ��������˿����������ڳɹ�����ߵĹ�����ֵ��ѧϰ��Ʒζ�������״��м�ȡ����ͽ�ѵ��");
		friendbookDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.book4);
		map.put("name", "������");
		map.put("uploadtime", "2014-2-5");
		map.put("author", "����");
		map.put("intro", "�������š�ͨ��������������ӽǣ�����߽�ʾ��һ������ʵ�ĸ���������������ӹ�ϵ��ʦ����ϵ��ͬѧ��ϵ������ì�ܺ�����չ�ֿ�����������ѧ��ʽ��˼������������롣");
		friendbookDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.book5);
		map.put("name", "һ���ǳ�");
		map.put("uploadtime", "2014-2-5");
		map.put("author", "����");
		map.put("intro", "�����ഺ����С˵���纫����˵����̱�֮�ơ����Ǹ����ڳ��еĹ��£����м��������ǵĴ����ϣ�������վ���ÿһ���ǳض��������ǵġ�");
		friendbookDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.book6);
		map.put("name", "͵Ӱ�ӵ���");
		map.put("uploadtime", "2014-2-1");
		map.put("author", "��ˡ���ά");
		map.put("intro", "һ������������Ϊ֮���ݵ���������С˵���ⲿ��Ʒ����չ�������������Ȥ��д������д������µ����顢�������˵İ���Ͳ��벻�������飬������������Ϣ��������˵Ĺ����໥��֯.");
		friendbookDataList.add(map);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friendinfo);
		
		Bundle bundle = this.getIntent().getExtras();
		String name = bundle.getString("name");
		
		friendName = (TextView) findViewById(R.id.friendinfoname );
		friendName.setText(name);
		
		setData();
		friendbooklistView = (ListView) findViewById(R.id.friendbook);
		SimpleAdapter listItemAdapter = new SimpleAdapter(this,
				friendbookDataList,
				R.layout.friendbooklist_item,
				new String[] {"img", "name", "author", "intro"},
				new int[] {R.id.bookimageid, R.id.booknameid, R.id.bookauthorid, R.id.bookintroid});
		friendbooklistView.setAdapter(listItemAdapter);
		friendbooklistView.setOnItemClickListener(bookItemClickListener);
	}
	
	private OnItemClickListener bookItemClickListener = new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(FriendInfoActivity.this, BookInfoActivity.class);
			Bundle bundle = new Bundle();
			bundle.putString("name", (String)friendbookDataList.get(arg2).get("name"));
			bundle.putString("author", (String)friendbookDataList.get(arg2).get("author"));
			bundle.putString("intro", (String)friendbookDataList.get(arg2).get("intro"));
			bundle.putString("uploadtime", (String)friendbookDataList.get(arg2).get("uploadtime"));
			intent.putExtras(bundle);
			startActivity(intent);
		}
	};
	
}
