package com.example.ebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MybookControlActivity extends ListActivity {    
    private Map<String, Object> map;
    private List<Map<String, Object>> data;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mybookset);
     
        data = new ArrayList<Map<String,Object>>();
        map = new HashMap<String, Object>();
        map.put("mytitle", "ÖÐ¹ú");
        map.put("myinfo", "China");
        map.put("myimage", R.drawable.head01);
        data.add(map);
        
        MybooksetViewAdapter myadapter=new MybooksetViewAdapter(this);
         
        myadapter.setData(data);
  
        setListAdapter(myadapter);
   
    }
}
