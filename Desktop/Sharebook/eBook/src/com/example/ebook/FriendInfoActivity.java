/** 在好友列表中点击好友后进入这个好友藏书信息页面  **/
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
		map.put("name", "全职高手");
		map.put("uploadtime", "2014-3-4");
		map.put("author", "蝴蝶蓝");
		map.put("intro", "勾心斗角之后，谁夺走了我的荣耀？风雨飘摇之下，希望却不曾破灭。花团锦簇之中，没有迷失了方向。万众瞩目之前，我，就在这里回归了！");
		friendbookDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.book2);
		map.put("name", "谁的青春不迷茫");
		map.put("uploadtime", "2014-3-1");
		map.put("author", "刘同");
		map.put("intro", "我们都一样，正处于期盼未来，挣脱过去，当下使劲的样子。会狼狈，有潇洒，但更多的是不怕。不怕动荡，不怕转机，不怕突然。谁的青春不迷茫，其实我们都一样。");
		friendbookDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.book3);
		map.put("name", "做最好的自己");
		map.put("uploadtime", "2014-2-18");
		map.put("author", "李开复");
		map.put("intro", "在这本书里的许多想法都是作者在过去的文章或信函中表达过的。在年轻人看来，发生在成功者身边的故事最值得学习和品味，最容易从中汲取经验和教训。");
		friendbookDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.book4);
		map.put("name", "三重门");
		map.put("uploadtime", "2014-2-5");
		map.put("author", "韩寒");
		map.put("intro", "《三重门》通过少年林雨翔的视角，向读者揭示了一个类真实的高中生的生活，把亲子关系、师生关系、同学关系的种种矛盾和问题展现开来，体现了学生式的思考、困惑和梦想。");
		friendbookDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.book5);
		map.put("name", "一座城池");
		map.put("uploadtime", "2014-2-5");
		map.put("author", "韩寒");
		map.put("intro", "韩寒青春流浪小说，如韩寒所说有里程碑之称。这是个关于城市的故事，城市寄托了我们的大多数希望，可终究，每一座城池都不是我们的。");
		friendbookDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("img", R.drawable.book6);
		map.put("name", "偷影子的人");
		map.put("uploadtime", "2014-2-1");
		map.put("author", "马克·李维");
		map.put("intro", "一部令整个法国为之动容的温情疗愈小说。这部作品完美展现了坐着温柔风趣的写作风格，有催人泪下的亲情、浪漫感人的爱情和不离不弃的友情，清新浪漫的气息和温柔感人的故事相互交织.");
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
