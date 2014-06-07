package network;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import baseclass.DB_user;
   
public class JsonParse {  
    /** 
     * 解析Json数据 
     *  
     * @param urlPath 
     * @return mlists 
     * @throws Exception 
     */  
  
    public static List<DB_user> getListPerson(String urlPath) throws Exception {  
    	
        List<DB_user> mlists = new ArrayList<DB_user>();  
        
        byte[] data = readParse(urlPath);  
        JSONArray array = new JSONArray(new String(data));  
        for (int i = 0; i < array.length(); i++) {  
        	
            JSONObject item = array.getJSONObject(i);  
            String name = item.getString("nickname");  
            String password = item.getString("password");  
            mlists.add(new DB_user(0,name,password,"",'\0',0,"",0,"",0,0,"",true,true,0)); 
        }  
        
        return mlists;  
    }  
  
    /** 
     * 从指定的url中获取字节数组 
     *  
     * @param urlPath 
     * @return 字节数组 
     * @throws Exception 
     */  
    public static byte[] readParse(String urlPath) throws Exception {  
    	ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        byte[] data = new byte[1024];  
        int len = 0;  
        URL url = new URL(urlPath);  
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();  
        InputStream inStream = conn.getInputStream();  
  
        while ((len = inStream.read(data)) != -1) {  
            outStream.write(data, 0, len);  
  
        }  
        inStream.close();  
        return outStream.toByteArray();  
    }  
} 
