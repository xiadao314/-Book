package manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.SocketTimeoutException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class OnlineManager{
	private BufferedWriter writer;
	private BufferedReader reader;
	public boolean run(String name,String pwd){
		Socket server;
		String txt;
		boolean info=false;
		try{
			server=new Socket();
			server.connect(new InetSocketAddress("114.215.172.222",8000),5000);
			SendMsg(server,"0 11");	
			SendMsg(server,name);
			SendMsg(server,pwd);
			String item=ReceiveMsg(server);
			if(item.equals("1 11 1"))
				info=true;	
			server.close();
			return info;
		}catch(IOException e){
			e.printStackTrace();
			return info;
		}
	}
	
	private Socket RequestSocket(String host,int port)throws UnknownHostException,IOException{
		Socket socket=new Socket(host,port);
		return socket;	
	}
	private void SendMsg(Socket socket,String Msg)throws IOException{
		writer=new BufferedWriter(
				new OutputStreamWriter(socket.getOutputStream()));
		writer.write(Msg.replace("\n"," ")+"\n");
		writer.flush();
	}
	private String ReceiveMsg(Socket socket)throws IOException{
		socket.setSoTimeout(5000);
		reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String txt=reader.readLine();
		return txt;
	}
}

