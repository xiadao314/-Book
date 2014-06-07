package com.example.ebook;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class SetupActivity extends Activity{
	@Override 
    public void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.setup); 
        //绑定Layout里面的ListView 
        ListView list = (ListView) findViewById(R.id.ListView01); 
         
        //生成动态数组，加入数据 
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>(); 
        for(int i=0;i<5;i++) 
        {
        	if(i==0){
        		HashMap<String, Object> map = new HashMap<String, Object>(); 
                map.put("ItemImage", R.drawable.child_image);//图像资源的ID 
                map.put("ItemTitle", "个人信息"); 
                map.put("LastImage", R.drawable.child_image); 
                listItem.add(map);
        	}else if(i==1){
        		HashMap<String, Object> map = new HashMap<String, Object>(); 
                map.put("ItemImage", R.drawable.child_image);//图像资源的ID 
                map.put("ItemTitle", "修改密码"); 
                map.put("LastImage", R.drawable.child_image); 
                listItem.add(map);
        	}else if(i==2){
        		HashMap<String, Object> map = new HashMap<String, Object>(); 
                map.put("ItemImage", R.drawable.child_image);//图像资源的ID 
                map.put("ItemTitle", "网络设置"); 
                map.put("LastImage", R.drawable.child_image); 
                listItem.add(map);
        	}else if(i==3){
        		HashMap<String, Object> map = new HashMap<String, Object>(); 
                map.put("ItemImage", R.drawable.child_image);//图像资源的ID 
                map.put("ItemTitle", "打印设置"); 
                map.put("LastImage", R.drawable.child_image); 
                listItem.add(map);
        	}else{
        		HashMap<String, Object> map = new HashMap<String, Object>(); 
                map.put("ItemImage", R.drawable.child_image);//图像资源的ID 
                map.put("ItemTitle", "返回"); 
                map.put("LastImage", R.drawable.child_image); 
                listItem.add(map);
        	}      
        } 
        //生成适配器的Item和动态数组对应的元素 
        
        SimpleAdapter listItemAdapter = new SimpleAdapter(this,listItem,// 数据源  
            R.layout.setuplistitem,//ListItem的XML实现 
            //动态数组与ImageItem对应的子项         
            
            new String[] {"ItemImage","ItemTitle", "LastImage"}, 
            //ImageItem的XML文件里面的一个ImageView,两个TextView ID 
            
            new int[] {R.id.ItemImage,R.id.ItemTitle,R.id.last} 
        ); 
        
        //添加并且显示 
        list.setAdapter(listItemAdapter); 
         
        //添加点击 
        list.setOnItemClickListener(new OnItemClickListener() { 
 
            @Override 
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, 
                    long arg3) { 
                setTitle("点击第"+arg2+"个项目"); 
                if(arg2 == 4){
                SetupActivity.this.finish();
                }
            } 
        }); 
         
      //添加长按点击 
        list.setOnCreateContextMenuListener(new OnCreateContextMenuListener() { 
             
            @Override 
            public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) {
                menu.setHeaderTitle("长按菜单-ContextMenu");    
                menu.add(0, 0, 0, "弹出长按菜单0"); 
                menu.add(0, 1, 0, "弹出长按菜单1");    
            }
        });  
    } 
     
    //长按菜单响应函数 
    @Override 
    public boolean onContextItemSelected(MenuItem item) { 
        setTitle("点击了长按菜单里面的第"+item.getItemId()+"个项目");  
        return super.onContextItemSelected(item); 
    }
}
