package manager;


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
import baseclass.DB_book;

public class FindBookManager extends Thread{
	private BufferedWriter writer;
	private BufferedReader reader;
	private int userId;
	private List<DB_book> data;
	
	public List<DB_book> run(String nickname){
		Socket client;
		BufferedReader bf;
		String msg;
		String bookname="",writer="",mark="";
		data=new ArrayList<DB_book>();
		try{
			client=new Socket();
			client.connect(new InetSocketAddress("114.215.172.222",8000),5000);
			SendMsg(client,"0 22");	
			SendMsg(client,nickname);
			int i=1;
			bf=ReceiveMsg(client);
			while(!(msg=bf.readLine()).equals("$"))
			{
				
				//System.out.println(i);
				//System.out.println(msg);
				if(i%3==1)
					bookname=URLDecoder.decode(msg,"utf-8");
				else if(i%3==2)
					writer=URLDecoder.decode(msg,"utf-8");
				else
				{
					mark=URLDecoder.decode(msg,"utf-8");;					
					data.add(new DB_book(0,bookname,writer,'\0',false,"",mark,"",0,""));
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
