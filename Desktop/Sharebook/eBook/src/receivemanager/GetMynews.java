package receivemanager;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import android.util.Log;
import baseclass.DB_user;

public class GetMynews extends Thread{
	private BufferedWriter writer;
	private BufferedReader reader;
	private int userId;
	private List<DB_user> data;
	
	public List<DB_user> run(String school){
		Socket client;
		BufferedReader bf;
		String msg;
		String nickname="",mark="",book="";
		data=new ArrayList<DB_user>();
		try{
			client=new Socket();
			client.connect(new InetSocketAddress("114.215.172.222",8000),1000);
			SendMsg(client,"0 40");	
			SendMsg(client,school);
			Log.i("GetMynews",school);
			int i=1;
			bf=ReceiveMsg(client);
			while(!(msg=bf.readLine()).equals("$"))
			{
				
				//System.out.println(i);
				//System.out.println(msg);
				if(i%3==1)
					nickname=msg;
				else if(i%3==2)
					mark=URLDecoder.decode(msg,"utf-8");
				else
				{
					book=msg;					
					data.add(new DB_user(0,nickname,"","",'0',0,"",0,mark,0,0,"",true,true,Integer.parseInt(book)));
				}
				i++;
			}
			client.close();
			bf.close();
			return data;
		}catch(IOException e){
			e.printStackTrace();
			return data;
		}
	}
	
	private void SendMsg(Socket socket,String Msg)throws IOException {
		writer=new BufferedWriter(
				new OutputStreamWriter(socket.getOutputStream()));
		writer.write(Msg.replace("\n"," ")+"\n");
		writer.flush();
	}
	
	private BufferedReader ReceiveMsg(Socket socket)throws IOException {
		reader=new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		return reader;
	}
}
