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
		map.put("uname", "张小明");
		map.put("bimg", R.drawable.book1);
		map.put("bname", "全职高手");
		map.put("uploadtime", "2014-5-1");
		map.put("bauthor", "蝴蝶蓝");
		map.put("bintro", "勾心斗角之后，谁夺走了我的荣耀？风雨飘摇之下，希望却不曾破灭。花团锦簇之中，没有迷失了方向。万众瞩目之前，我，就在这里回归了！");
		map.put("goodnum", "3");
		map.put("comnum", "5");
		bookDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("uimg", R.drawable.head01);
		map.put("uname", "潘小花");
		map.put("bimg", R.drawable.book2);
		map.put("bname", "谁的青春不迷茫");
		map.put("uploadtime", "2014-4-22");
		map.put("bauthor", "刘同");
		map.put("bintro", "我们都一样，正处于期盼未来，挣脱过去，当下使劲的样子。会狼狈，有潇洒，但更多的是不怕。不怕动荡，不怕转机，不怕突然。谁的青春不迷茫，其实我们都一样。");
		map.put("goodnum", "11");
		map.put("comnum", "2");
		bookDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("uimg", R.drawable.head01);
		map.put("uname", "王妮玛");
		map.put("bimg", R.drawable.book3);
		map.put("bname", "做最好的自己");
		map.put("uploadtime", "2014-4-21");
		map.put("bauthor", "李开复");
		map.put("bintro", "在这本书里的许多想法都是作者在过去的文章或信函中表达过的。在年轻人看来，发生在成功者身边的故事最值得学习和品味，最容易从中汲取经验和教训。");
		map.put("goodnum", "8");
		map.put("comnum", "15");
		bookDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("uimg", R.drawable.head01);
		map.put("uname", "韩萌");
		map.put("bimg", R.drawable.book4);
		map.put("bname", "三重门");
		map.put("uploadtime", "2014-4-7");
		map.put("bauthor", "韩寒");
		map.put("bintro", "《三重门》通过少年林雨翔的视角，向读者揭示了一个类真实的高中生的生活，把亲子关系、师生关系、同学关系的种种矛盾和问题展现开来，体现了学生式的思考、困惑和梦想。");
		map.put("goodnum", "23");
		map.put("comnum", "18");
		bookDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("uimg", R.drawable.head01);
		map.put("uname", "韩萌");
		map.put("bimg", R.drawable.book5);
		map.put("bname", "一座城池");
		map.put("uploadtime", "2014-4-5");
		map.put("bauthor", "韩寒");
		map.put("bintro", "韩寒青春流浪小说，如韩寒所说有里程碑之称。这是个关于城市的故事，城市寄托了我们的大多数希望，可终究，每一座城池都不是我们的。");
		map.put("goodnum", "13");
		map.put("comnum", "17");
		bookDataList.add(map);
		
		map=new HashMap<String,Object>();
		map.put("uimg", R.drawable.head01);
		map.put("uname", "潘小花");
		map.put("bimg", R.drawable.book6);
		map.put("bname", "偷影子的人");
		map.put("uploadtime", "2014-4-1");
		map.put("bauthor", "马克·李维");
		map.put("bintro", "一部令整个法国为之动容的温情疗愈小说。这部作品完美展现了坐着温柔风趣的写作风格，有催人泪下的亲情、浪漫感人的爱情和不离不弃的友情，清新浪漫的气息和温柔感人的故事相互交织.");
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
        map.put("title", "中国");
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
    		map.put("uname", "潘小花");
    		map.put("bimg", R.drawable.book6);
    		map.put("bname", "偷影子的人");
    		map.put("uploadtime", "2014-4-1");
    		map.put("bauthor", "马克·李维");
    		map.put("bintro", "一部令整个法国为之动容的温情疗愈小说。这部作品完美展现了坐着温柔风趣的写作风格，有催人泪下的亲情、浪漫感人的爱情和不离不弃的友情，清新浪漫的气息和温柔感人的故事相互交织.");
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
