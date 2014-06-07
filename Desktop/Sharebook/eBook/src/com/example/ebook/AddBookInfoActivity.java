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
	                    
				//�����ȷ���ϴ�����ť��������Ϊ��ʱ�����ҵ������棬���ڽ����listview���������ӵ��鼮
		        //��ΪͼƬ��activity�в��ô��ݣ���������Ĭ�ϵ�ͼƬ����demo�������̨�������ԴӺ�̨������
				if(!bookname.toString().equals(""))
		        {
					if(author.equals(""))
					{
						author = "��������";
					}
					if(intro.equals(""))
					{
						intro = "���޼��";
					}
					if(addbookmanager.run(nickname,bookname,author,'r',false,"", intro))
						Toast.makeText(AddBookInfoActivity.this,"��ӳɹ�", Toast.LENGTH_SHORT).show();
					else
						Toast.makeText(AddBookInfoActivity.this,"���ʧ��", Toast.LENGTH_SHORT).show();
							
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
					Toast.makeText(AddBookInfoActivity.this,"����������Ϊ��", Toast.LENGTH_SHORT).show();
			}
        	
        });
            
	}
}
