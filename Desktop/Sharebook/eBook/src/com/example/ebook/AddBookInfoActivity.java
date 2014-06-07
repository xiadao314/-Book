package com.example.ebook;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import manager.AddBookManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddBookInfoActivity extends Activity {
	
	private ImageView newimgView;
	private EditText newnameET;
	private EditText newauthorET;
	private EditText newintroET;
	private Button uploadimgBtn;
	private Button uploadallBtn;
	private AddBookManager addbookmanager;
	private String bookname,author,intro;
	private String nickname;
		
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addbookinfo);
        nickname=getIntent().getStringExtra("nickname");
        
        newimgView = (ImageView) findViewById(R.id.newbookimg);
        newnameET = (EditText) findViewById(R.id.newbookname);
        newauthorET = (EditText) findViewById(R.id.newbookauthor);
        newintroET = (EditText) findViewById(R.id.newbookintro);
        uploadimgBtn = (Button) findViewById(R.id.uploadnewimg);
        uploadallBtn = (Button) findViewById(R.id.uploadbook);
        addbookmanager=new AddBookManager();
        
        uploadallBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				try {
					bookname = URLEncoder.encode(newnameET.getText().toString(),"utf-8");
					author = URLEncoder.encode(newauthorET.getText().toString(),"utf-8");
			        intro = URLEncoder.encode(newintroET.getText().toString(),"utf-8");
			        Log.i("test",bookname+author+intro);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	                    
				//点击“确认上传”按钮且书名不为空时返回我的书库界面，并在界面的listview上新增增加的书籍
		        //因为图片在activity中不好传递，所以先用默认的图片做个demo，加入后台处理后可以从后台拉数据
				if(!bookname.toString().equals(""))
		        {
					if(author.equals(""))
					{
						author = "暂无作者";
					}
					if(intro.equals(""))
					{
						intro = "暂无简介";
					}
					if(addbookmanager.run(nickname,bookname,author,'r',false,"", intro))
						Toast.makeText(AddBookInfoActivity.this,"添加成功", Toast.LENGTH_SHORT).show();
					else
						Toast.makeText(AddBookInfoActivity.this,"添加失败", Toast.LENGTH_SHORT).show();
							
		        	/*Intent intent = new Intent();
		        	intent.setClass(AddBookInfoActivity.this, MybookControlActivity.class);
		        	Bundle bundle = new Bundle();	            
		        	bundle.putString("newname", bookname);
		        	bundle.putString("newauthor", author);
		        	bundle.putString("newintro", intro);
		        	intent.putExtras(bundle);
		        	//startActivity(intent);
		        	AddBookInfoActivity.this.setResult(RESULT_OK, intent);*/
		        	finish();
		        }
				else 
					Toast.makeText(AddBookInfoActivity.this,"书名不可以为空", Toast.LENGTH_SHORT).show();
			}
        	
        });
            
	}
}
