package baseclass;

public class DB_chat {
	 
	private int Cid;
	private int fromUid;
	private int toUid;
	private String content;
	private long time;
	
	public DB_chat( int Cid,
			        int fromUid,
			        int toUid,
			        String content,
			        long time) {
		this.Cid = Cid;
		this.fromUid = fromUid;
		this.toUid = toUid;
		this.content = content;
		this.time = time;
	}


	public int getCid() {
		return Cid;
	}
	
	public void setCid(int id) {
		this.Cid = id;
	}
	
	public int getFromUid() {
		return fromUid;
	}
	
	public void setFromUid(int fromUid) {
	this.fromUid = fromUid;
	}
	
	public int getToUid() {
		return toUid;
	}
	
	public void setToUid(int toUid) {
		this.toUid = toUid;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this. content = content;
	}
	
	public long getTime() {
		return time;
	}
	
	public void setTime(long time) {
		this.time = time;
	}
}