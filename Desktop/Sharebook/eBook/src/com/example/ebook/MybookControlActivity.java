package com.example.ebook;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import manager.FindBookManager;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import baseclass.DB_book;

public class MybookControlActivity extends Activity {    
    //private Map<String, Object> map;
    //private List<Map<String, Object>> data;
    
	private Button addBookBtn;
	private Button refreshBookBtn;
	private ListView myBookListView;
	private Map<String,Object> map=new HashMap<String,Object>();
	private String nickname;
	private FindBookManager findbookmanager;
	
	private List<Map<String,Object>> myBookDataList=new ArrayList<Map<String,Object>>();	
	GetDataTask test;
		
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mybook);
        
        nickname=getIntent().getStringExtra("nickname");
        
        addBookBtn = (Button) findViewById(R.id.addmybook);
        refreshBookBtn = (Button) findViewById(R.id.refreshmybook);
        myBookListView = (ListView) findViewById(R.id.mybooklist);
        test=new GetDataTask();
		test.execute();
        
        addBookBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra("nickname", nickname);
				intent.setClass(MybookControlActivity.this, AddBookInfoActivity.class);
				startActivityForResult(intent, 0);
			}
        	
        });
        
        
        //点击刷新按钮后执行的代码写在此处
        refreshBookBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        
    }
    private class GetDataTask extends AsyncTask<Void, Void, List<DB_book>> {

        @Override
        protected List<DB_book> doInBackground(Void... params) {
            // Simulates a background job.
        	findbookmanager=new FindBookManager();      	
        	List<DB_book> data=new ArrayList<DB_book>();
			try {
				data = findbookmanager.run(URLEncoder.encode(nickname,"utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return data;
			}
            return data;
        }
        @Override
        protected void onPreExecute() {   
        	
      
        	
        }
        @Override
        protected void onPostExecute(List<DB_book> result) {   
        	
        	int count=result.size();
        	Map<String, Object> map;
        	Toast.makeText(MybookControlActivity.this,"努力加载中请稍等", Toast.LENGTH_SHORT).show();
        	myBookDataList.clear();
        	if(count==0)
        		Toast.makeText(MybookControlActivity.this,"你还没有添加书籍哦", Toast.LENGTH_SHORT).show();
        	
        	while(count>0)
        	{
        		map=new HashMap<String,Object>();
        		map.put("img", R.drawable.initialbookimg);
        		map.put("name", result.get(count-1).getName());
        		
        		System.out.println(result.get(count-1).getName());
        		
        		map.put("author", result.get(count-1).getWriter());
        		map.put("intro",result.get(count-1).getMark());
        		myBookDataList.add(map);
        		count--;
        	} 
        	      	
        	Toast.makeText(MybookControlActivity.this,"加载完毕", Toast.LENGTH_SHORT).show();
        	myBookListView.setAdapter(new SimpleAdapter(MybookControlActivity.this,
        		myBookDataList,
				R.layout.mybooklist_item,
				new String[] {"img", "name", "author", "intro"},
				new int[] {R.id.mybookimageid, R.id.mybooknameid, R.id.mybookauthorid, R.id.mybookintroid}));
        	
            super.onPostExecute(result);
        }
    }
	
    /*
    //如果有新添加的书籍，在这里获取新添加书籍的数据并增加到listview中并更新显示
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
    	switch(resultCode)
    	{
    	case RESULT_OK:
    		Bundle bundle = data.getExtras();
    		String newname = bundle.getString("newname");
        	String newauthor = bundle.getString("newauthor");
        	String newintro = bundle.getString("newintro");
        	map=new HashMap<String,Object>();
        	map.put("img", R.drawable.initialbookimg);
        	map.put("name", newname);
        	map.put("author", newauthor);
			map.put("intro", newintro);
			System.out.println(newname);
			System.out.println(newauthor);
			System.out.println(newintro);
			myBookDataList.add(map);
			
			SimpleAdapter listItemAdapter = new SimpleAdapter(this,
	        		myBookDataList,
					R.layout.mybooklist_item,
					new String[] {"img", "name", "author", "intro"},
					new int[] {R.id.mybookimageid, R.id.mybooknameid, R.id.mybookauthorid, R.id.mybookintroid});
	        myBookListView.setAdapter(listItemAdapter);
			break;
		default:
			break;
				
    	}
    }*/
}
