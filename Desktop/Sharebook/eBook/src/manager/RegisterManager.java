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


public class RegisterManager {
	private BufferedWriter writer;
	private BufferedReader reader;
	private int userId;
	
	public boolean run(String name,String pwd){
		Socket client;
		String msg;
		boolean info=false;
		try{
			client=new Socket();
			client.connect(new InetSocketAddress("114.215.172.222",8000),1000);
			SendMsg(client,"0 10");	
			SendMsg(client,name);
			SendMsg(client,pwd);
			msg=ReceiveMsg(client);
			if(msg.equals("1 10 1")) {
				info=true;	
				msg=ReceiveMsg(client);
				userId=Integer.parseInt(msg);
			}
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
		socket.setSoTimeout(1000);
		reader=new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		String txt=reader.readLine();
		return txt;
	}
}
