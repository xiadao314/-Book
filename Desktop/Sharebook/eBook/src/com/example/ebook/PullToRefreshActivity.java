package com.example.ebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.ebook.PullToRefreshListView.OnRefreshListener;

public class PullToRefreshActivity extends ListActivity {    
    private Map<String, Object> map;
    private List<Map<String, Object>> data;
    
    /*
    private ListView booklistView;
	private List<Map<String,Object>> bookDataList=new ArrayList<Map<String,Object>>();
	
	private void setData(){
		//Map<String,Object> map=new HashMap<String,Object>();

		map=new HashMap<String,Object>();
		map.put("uimg", R.drawable.head01);
		map.put("uname", "��С��");
		map.put("bimg", R.drawable.book1);
		map.put("bname", "ȫְ����");
		map.put("uploadtime", "2014-5-1");
		map.put("bauthor", "������");
		map.put("bintro", "���Ķ���֮��˭�������ҵ���ҫ������Ʈҡ֮�£�ϣ��ȴ�������𡣻��Ž���֮�У�û����ʧ�˷���������Ŀ֮ǰ���ң���������ع��ˣ�");
		map.put("goodnum", "3");
		map.put("comnum", "5");
		bookDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("uimg", R.drawable.head01);
		map.put("uname", "��С��");
		map.put("bimg", R.drawable.book2);
		map.put("bname", "˭���ഺ����ã");
		map.put("uploadtime", "2014-4-22");
		map.put("bauthor", "��ͬ");
		map.put("bintro", "���Ƕ�һ��������������δ�������ѹ�ȥ������ʹ�������ӡ����Ǳ�������������������ǲ��¡����¶���������ת��������ͻȻ��˭���ഺ����ã����ʵ���Ƕ�һ����");
		map.put("goodnum", "11");
		map.put("comnum", "2");
		bookDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("uimg", R.drawable.head01);
		map.put("uname", "������");
		map.put("bimg", R.drawable.book3);
		map.put("bname", "����õ��Լ�");
		map.put("uploadtime", "2014-4-21");
		map.put("bauthor", "���");
		map.put("bintro", "���Ȿ���������뷨���������ڹ�ȥ�����»��ź��б����ġ��������˿����������ڳɹ�����ߵĹ�����ֵ��ѧϰ��Ʒζ�������״��м�ȡ����ͽ�ѵ��");
		map.put("goodnum", "8");
		map.put("comnum", "15");
		bookDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("uimg", R.drawable.head01);
		map.put("uname", "����");
		map.put("bimg", R.drawable.book4);
		map.put("bname", "������");
		map.put("uploadtime", "2014-4-7");
		map.put("bauthor", "����");
		map.put("bintro", "�������š�ͨ��������������ӽǣ�����߽�ʾ��һ������ʵ�ĸ���������������ӹ�ϵ��ʦ����ϵ��ͬѧ��ϵ������ì�ܺ�����չ�ֿ�����������ѧ��ʽ��˼������������롣");
		map.put("goodnum", "23");
		map.put("comnum", "18");
		bookDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("uimg", R.drawable.head01);
		map.put("uname", "����");
		map.put("bimg", R.drawable.book5);
		map.put("bname", "һ���ǳ�");
		map.put("uploadtime", "2014-4-5");
		map.put("bauthor", "����");
		map.put("bintro", "�����ഺ����С˵���纫����˵����̱�֮�ơ����Ǹ����ڳ��еĹ��£����м��������ǵĴ����ϣ�������վ���ÿһ���ǳض��������ǵġ�");
		map.put("goodnum", "13");
		map.put("comnum", "17");
		bookDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("uimg", R.drawable.head01);
		map.put("uname", "��С��");
		map.put("bimg", R.drawable.book6);
		map.put("bname", "͵Ӱ�ӵ���");
		map.put("uploadtime", "2014-4-1");
		map.put("bauthor", "��ˡ���ά");
		map.put("bintro", "һ������������Ϊ֮���ݵ���������С˵���ⲿ��Ʒ����չ�������������Ȥ��д������д������µ����顢�������˵İ���Ͳ��벻�������飬������������Ϣ��������˵Ĺ����໥��֯.");
		map.put("goodnum", "15");
		map.put("comnum", "8");
		bookDataList.add(map);
	}
	*/
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pull_to_refresh);
        
        // Set a listener to be invoked when the list should be refreshed.
        ((PullToRefreshListView) getListView()).setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Do work to refresh the list here.
                new GetDataTask().execute();
            }
        });

        
        data = new ArrayList<Map<String,Object>>();
        map = new HashMap<String, Object>();
        map.put("title", "�й�");
        map.put("info", "China");
        map.put("image", R.drawable.head01);
        data.add(map);
        
        MainListViewAdapter myadapter=new MainListViewAdapter(this);
         
        myadapter.setData(data);
        
        setListAdapter(myadapter);
        
        /*
        setData();
		booklistView = (ListView) findViewById(R.id.);
		SimpleAdapter listItemAdapter = new SimpleAdapter(this,
				bookDataList,
				R.layout.pull_to_refreshlist_item,
				new String[] {"uimg", "uname", "uploadtime", "bimg", "bname", "bauthor", "bintro", "goodnum", "comnum"},
				new int[] {R.id.pull_userimg, R.id.pull_username, R.id.pull_uploadtime, R.id.pull_bookimg, R.id.pull_bookname, R.id.pull_bookauthor,
				R.id.pull_bookintro, R.id.pull_goodnum, R.id.pull_comnum});
		booklistView.setAdapter(listItemAdapter);
		*/
    }

    
    private class GetDataTask extends AsyncTask<Void, Void, List<Map<String, Object>>> {

        @Override
        protected List<Map<String, Object>> doInBackground(Void... params) {
            // Simulates a background job.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                ;
            }
            return data;
        }

        @Override
        protected void onPostExecute(List<Map<String, Object>> result) {
        	map=new HashMap<String,Object>();
    		map.put("uimg", R.drawable.head01);
    		map.put("uname", "��С��");
    		map.put("bimg", R.drawable.book6);
    		map.put("bname", "͵Ӱ�ӵ���");
    		map.put("uploadtime", "2014-4-1");
    		map.put("bauthor", "��ˡ���ά");
    		map.put("bintro", "һ������������Ϊ֮���ݵ���������С˵���ⲿ��Ʒ����չ�������������Ȥ��д������д������µ����顢�������˵İ���Ͳ��벻�������飬������������Ϣ��������˵Ĺ����໥��֯.");
    		map.put("goodnum", "15");
    		map.put("comnum", "8");
    		data.add(map);
            result.add(map);
            
            // Call onRefreshComplete when the list has been refreshed.
            ((PullToRefreshListView) getListView()).onRefreshComplete();

            super.onPostExecute(result);
        }
    }
    
}
