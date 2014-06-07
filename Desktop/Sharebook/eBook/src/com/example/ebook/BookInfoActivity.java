/** ��ĳ�����Ѳ�����Ϣ�����е����Ŀ���������ϸ��Ϣ����  **/
package com.example.ebook;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class BookInfoActivity extends Activity{

	private TextView bookName;
	private TextView bookAuthor;
	private TextView bookTime;
	private TextView bookIntro;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bookinfo);
		
		Bundle bundle = this.getIntent().getExtras();
		String name = bundle.getString("name");
		String author = bundle.getString("author");
		String intro = bundle.getString("intro");
		String uploadtime = bundle.getString("uploadtime");
		
		bookName = (TextView) findViewById(R.id.bbooknameid);
		bookAuthor = (TextView) findViewById(R.id.bbookauthorid);
		bookTime = (TextView) findViewById(R.id.bbooktimeid);
		bookIntro = (TextView) findViewById(R.id.bbookintroid);
		
		bookName.setText(name);
		bookAuthor.setText(author);
		bookTime.setText(uploadtime);
		bookIntro.setText(intro);
	}
		
}
