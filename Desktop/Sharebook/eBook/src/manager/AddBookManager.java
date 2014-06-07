package manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;


public class AddBookManager {
	private BufferedWriter writer;
	private BufferedReader reader;
	
	public boolean run(String nickname,String name, String writer, char type, boolean state, String label, String mark){
		Socket client;
		String msg;
		boolean info=false;
		try{
			client=new Socket();
			client.connect(new InetSocketAddress("114.215.172.222",8000),1000);
			SendMsg(client,"0 20");	
			SendMsg(client,nickname);
			SendMsg(client,name);
			SendMsg(client,writer);
			SendMsg(client,String.valueOf(type));
			SendMsg(client,String.valueOf(state));
			SendMsg(client,label);
			SendMsg(client,mark);
			msg=ReceiveMsg(client);
			if(msg.equals("1 20 1"))
				info=true;				
			client.close();
			return info;
		}catch(IOException e){
			e.printStackTrace();
			return info;
		}
	}
	
	private void SendMsg(Socket socket,String Msg)throws IOException {
		writer=new BufferedWriter(
				new OutputStreamWriter(socket.getOutputStream()));
		writer.write(Msg.replace("\n"," ")+"\n");
		writer.flush();
	}
	
	private String ReceiveMsg(Socket socket)throws IOException {
		reader=new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		String txt=reader.readLine();
		return txt;
	}
}
