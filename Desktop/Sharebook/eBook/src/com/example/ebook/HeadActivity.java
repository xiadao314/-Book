package com.example.ebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class HeadActivity extends Activity {
	
	public int[] HeadId;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		HeadId=new int[]{R.drawable.head01};
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.head);
		GridView gridview=(GridView)findViewById(R.id.headview);
		
		BaseAdapter adapter=new BaseAdapter(){	
			@Override
			public View getView(int position,View convertView,ViewGroup parent){
				ImageView imageview;
				if(convertView==null){
					imageview=new ImageView(HeadActivity.this);
					/******************设置图像的宽度和高度********************/
					imageview.setAdjustViewBounds(true);
					imageview.setMaxWidth(158);
					imageview.setMaxHeight(150);
					/***************************************************/
					imageview.setPadding(5,5,5,5);            //设置ImageView的内边距
					
				}else{
					imageview=(ImageView)convertView;
				}
				imageview.setImageResource(HeadId[position]);
				return imageview;				
			}
			
			@Override
			public long getItemId(int position){
				return position;
			}
			
			@Override
			public Object getItem(int position){
				return position;
			}
			
			@Override
			public int getCount(){
				return HeadId.length;
			}
		};
		gridview.setAdapter(adapter);
		gridview.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent,View view,int position,long id){
				Intent intent=getIntent();
				Bundle bundle=new Bundle();
				bundle.putInt("HeadId",HeadId[position]);
				intent.putExtras(bundle);
				setResult(0x11,intent);
				finish();
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
