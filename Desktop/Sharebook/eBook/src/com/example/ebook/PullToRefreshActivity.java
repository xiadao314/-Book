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

import com.example.ebook.PullToRefreshListView.OnRefreshListener;

public class PullToRefreshActivity extends ListActivity {    
    private Map<String, Object> map;
    private List<Map<String, Object>> data;
    
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
        	map = new HashMap<String, Object>();
            map.put("title", "美国");
            map.put("info", "China");
            map.put("image", R.drawable.head01);
            result.add(map);
            
            // Call onRefreshComplete when the list has been refreshed.
            ((PullToRefreshListView) getListView()).onRefreshComplete();

            super.onPostExecute(result);
        }
    }
}
