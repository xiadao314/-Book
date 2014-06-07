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
	//程序加载显示到UI时先要读取的，决定了listview显示多少行
	@Override
	public int getCount(){
		return data.size();
	}
		
	//根绝listview的位置返回view
	@Override
	public Object getItem(int position){
		return this.data.get(position);
		
	}
	//根据listview的位置得到数据源集中的ID
	@Override
	public long getItemId(int position){
		return position;
	}
	
	//最重要的方法，决定listview界面的样式的
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
            //不懂这里setTag什么意思??
            convertView.setTag(holder);
		}
		else{
			holder=(ViewHolder)convertView.getTag();
		}
		holder.image.setBackgroundResource((Integer) data.get(position).get("myimage"));
        holder.title.setText((String) data.get(position).get("mytitle"));
        holder.info.setText((String) data.get(position).get("myinfo"));
        
        //为listview上的button添加click监听
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
