package com.example.ebook;

import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;



public class MybooksetViewAdapter extends BaseAdapter{
	private LayoutInflater inflater;
	private List<Map<String,Object>> data;
	
	public MybooksetViewAdapter(Context context){
		this.inflater=LayoutInflater.from(context);
	}
	
	public void setData(List<Map<String,Object>> item)
	{
		data=item;
	}
	//���������ʾ��UIʱ��Ҫ��ȡ�ģ�������listview��ʾ������
	@Override
	public int getCount(){
		return data.size();
	}
		
	//����listview��λ�÷���view
	@Override
	public Object getItem(int position){
		return this.data.get(position);
		
	}
	//����listview��λ�õõ�����Դ���е�ID
	@Override
	public long getItemId(int position){
		return position;
	}
	
	//����Ҫ�ķ���������listview�������ʽ��
	@Override
	public View getView(int position,View convertView,ViewGroup parent){
		ViewHolder holder=null;
		if(convertView==null)
		{
			holder=new ViewHolder();
			
			convertView=inflater.inflate(R.layout.mybooklistview,null);
			holder.image = (ImageView) convertView.findViewById(R.id.myimage);
            holder.title = (TextView) convertView.findViewById(R.id.mytitle);
            holder.info = (TextView) convertView.findViewById(R.id.myinfo);
            holder.viewBtn = (Button) convertView.findViewById(R.id.myviewBtn);
            //��������setTagʲô��˼??
            convertView.setTag(holder);
		}
		else{
			holder=(ViewHolder)convertView.getTag();
		}
		holder.image.setBackgroundResource((Integer) data.get(position).get("myimage"));
        holder.title.setText((String) data.get(position).get("mytitle"));
        holder.info.setText((String) data.get(position).get("myinfo"));
        
        //Ϊlistview�ϵ�button���click����
        holder.viewBtn.setOnClickListener(new View.OnClickListener() {
        	@Override
            public void onClick(View v){
        		
            }
        });

        return convertView;
	}
	static class ViewHolder {
        TextView title,info;
        ImageView image;
        Button viewBtn;
    }
	
}
