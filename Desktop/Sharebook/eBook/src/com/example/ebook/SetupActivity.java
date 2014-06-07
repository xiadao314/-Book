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
        //��Layout�����ListView 
        ListView list = (ListView) findViewById(R.id.ListView01); 
         
        //���ɶ�̬���飬�������� 
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>(); 
        for(int i=0;i<5;i++) 
        {
        	if(i==0){
        		HashMap<String, Object> map = new HashMap<String, Object>(); 
                map.put("ItemImage", R.drawable.child_image);//ͼ����Դ��ID 
                map.put("ItemTitle", "������Ϣ"); 
                map.put("LastImage", R.drawable.child_image); 
                listItem.add(map);
        	}else if(i==1){
        		HashMap<String, Object> map = new HashMap<String, Object>(); 
                map.put("ItemImage", R.drawable.child_image);//ͼ����Դ��ID 
                map.put("ItemTitle", "�޸�����"); 
                map.put("LastImage", R.drawable.child_image); 
                listItem.add(map);
        	}else if(i==2){
        		HashMap<String, Object> map = new HashMap<String, Object>(); 
                map.put("ItemImage", R.drawable.child_image);//ͼ����Դ��ID 
                map.put("ItemTitle", "��������"); 
                map.put("LastImage", R.drawable.child_image); 
                listItem.add(map);
        	}else if(i==3){
        		HashMap<String, Object> map = new HashMap<String, Object>(); 
                map.put("ItemImage", R.drawable.child_image);//ͼ����Դ��ID 
                map.put("ItemTitle", "��ӡ����"); 
                map.put("LastImage", R.drawable.child_image); 
                listItem.add(map);
        	}else{
        		HashMap<String, Object> map = new HashMap<String, Object>(); 
                map.put("ItemImage", R.drawable.child_image);//ͼ����Դ��ID 
                map.put("ItemTitle", "����"); 
                map.put("LastImage", R.drawable.child_image); 
                listItem.add(map);
        	}      
        } 
        //������������Item�Ͷ�̬�����Ӧ��Ԫ�� 
        
        SimpleAdapter listItemAdapter = new SimpleAdapter(this,listItem,// ����Դ  
            R.layout.setuplistitem,//ListItem��XMLʵ�� 
            //��̬������ImageItem��Ӧ������         
            
            new String[] {"ItemImage","ItemTitle", "LastImage"}, 
            //ImageItem��XML�ļ������һ��ImageView,����TextView ID 
            
            new int[] {R.id.ItemImage,R.id.ItemTitle,R.id.last} 
        ); 
        
        //��Ӳ�����ʾ 
        list.setAdapter(listItemAdapter); 
         
        //��ӵ�� 
        list.setOnItemClickListener(new OnItemClickListener() { 
 
            @Override 
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, 
                    long arg3) { 
                setTitle("�����"+arg2+"����Ŀ"); 
                if(arg2 == 4){
                SetupActivity.this.finish();
                }
            } 
        }); 
         
      //��ӳ������ 
        list.setOnCreateContextMenuListener(new OnCreateContextMenuListener() { 
             
            @Override 
            public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) {
                menu.setHeaderTitle("�����˵�-ContextMenu");    
                menu.add(0, 0, 0, "���������˵�0"); 
                menu.add(0, 1, 0, "���������˵�1");    
            }
        });  
    } 
     
    //�����˵���Ӧ���� 
    @Override 
    public boolean onContextItemSelected(MenuItem item) { 
        setTitle("����˳����˵�����ĵ�"+item.getItemId()+"����Ŀ");  
        return super.onContextItemSelected(item); 
    }
}
