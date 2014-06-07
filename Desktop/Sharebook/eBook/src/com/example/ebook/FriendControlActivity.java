package com.example.ebook;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FriendControlActivity extends Activity{
	
	private Button addFriend;
	
	protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.friend);

        final ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
            //设置组视图的图片
            int[] logos = new int[] { R.drawable.user_group, R.drawable.user_group,R.drawable.user_group};
            //设置组视图的显示文字
            private String[] generalsTypes = new String[] { "魏", "蜀", "吴" };
            //子视图显示文字
            private String[][] generals = new String[][] {
                    { "夏侯惇", "甄姬", "许褚", "郭嘉", "司马懿", "杨修" },
                    { "马超", "张飞", "刘备", "诸葛亮", "黄月英", "赵云" },
                    { "吕蒙", "陆逊", "孙权", "周瑜", "孙尚香" }

            };
            //子视图图片
            public int[][] generallogos = new int[][] {
                    { R.drawable.child_image, R.drawable.child_image,
                            R.drawable.child_image, R.drawable.child_image,
                            R.drawable.child_image, R.drawable.child_image },
                    { R.drawable.child_image, R.drawable.child_image,
                            R.drawable.child_image, R.drawable.child_image,
                            R.drawable.child_image, R.drawable.child_image },
                    { R.drawable.child_image, R.drawable.child_image, R.drawable.child_image,
                            R.drawable.child_image, R.drawable.child_image } };
            
            //自己定义一个获得文字信息的方法
            TextView getTextView() {
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                        ViewGroup.LayoutParams.FILL_PARENT, 64);
                TextView textView = new TextView(
                        FriendControlActivity.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL);
                textView.setPadding(36, 0, 0, 0);
                textView.setTextSize(20);
                textView.setTextColor(Color.BLACK);
                return textView;
            }

            
            //重写FriendControlAdapter中的各个方法
            @Override
            public int getGroupCount() {
                // TODO Auto-generated method stub
                return generalsTypes.length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                // TODO Auto-generated method stub
                return generalsTypes[groupPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                // TODO Auto-generated method stub
                return groupPosition;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                // TODO Auto-generated method stub
                return generals[groupPosition].length;
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                // TODO Auto-generated method stub
                return generals[groupPosition][childPosition];
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                // TODO Auto-generated method stub
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                // TODO Auto-generated method stub
                return true;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded,
                    View convertView, ViewGroup parent) {
                // TODO Auto-generated method stub
                LinearLayout ll = new LinearLayout(
                        FriendControlActivity.this);
                ll.setOrientation(0);
                ImageView logo = new ImageView(FriendControlActivity.this);
                logo.setImageResource(logos[groupPosition]);
                logo.setPadding(50, 0, 0, 0);
                ll.addView(logo);
                TextView textView = getTextView();
                textView.setTextColor(Color.BLACK);
                textView.setText(getGroup(groupPosition).toString());
                ll.addView(textView);

                return ll;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition,boolean isLastChild, View convertView, ViewGroup parent) {
                // TODO Auto-generated method stub
                LinearLayout ll = new LinearLayout(
                        FriendControlActivity.this);
                ll.setOrientation(0);
                ImageView generallogo = new ImageView(
                        FriendControlActivity.this);
                generallogo
                        .setImageResource(generallogos[groupPosition][childPosition]);
                ll.addView(generallogo);
                TextView textView = getTextView();
                textView.setText(getChild(groupPosition, childPosition)
                        .toString());
                ll.addView(textView);
                return ll;
            }

            @Override
            public boolean isChildSelectable(int groupPosition,int childPosition) {
                // TODO Auto-generated method stub
                return true;
            }

        };

        ExpandableListView FriendControlView = (ExpandableListView) findViewById(R.id.friendlist);
        
        FriendControlView.setAdapter(adapter);
        
        //设置item点击的监听器
        FriendControlView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                    int groupPosition, int childPosition, long id) {
				
            	Intent intent = new Intent();
            	intent.setClass(FriendControlActivity.this, FriendInfoActivity.class);
            	Bundle bundle = new Bundle();
            	bundle.putString("name", adapter.getChild(groupPosition, childPosition).toString());
            	intent.putExtras(bundle);
            	startActivity(intent);
            	
                return false;
            }
        });
        
        
        FriendControlView.setOnItemLongClickListener(new OnItemLongClickListener() {

    		@Override
    		public boolean onItemLongClick(AdapterView<?> arg0, final View arg1,
    				int arg2, long arg3) {
    			
    			final CharSequence[] items = {"删除好友", "查看好友信息"};
    			AlertDialog.Builder builder = new AlertDialog.Builder(FriendControlActivity.this);
    			builder.setItems(items, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						
					}
    				
   
    			});
    			
    			builder.show();
    			
    			AlertDialog alert = builder.create();
    			
    			return true;
    		}
    	});
        
        
        addFriend = (Button) findViewById(R.id.addFriendbtn);
        addFriend.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(FriendControlActivity.this, AddFriendActivity.class);
				startActivity(intent);
			}
        	
        });
    }
	
}
