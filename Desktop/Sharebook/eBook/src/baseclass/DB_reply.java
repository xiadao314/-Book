package baseclass;

public class DB_reply {
	
	private int Rid;
	private int Mid;
	private int Uid;
	private String content;
	private long time;
	
	public DB_reply( int Rid,
			         int Mid,
			         int Uid,
			         String content,
			         long time ) { 
		this.Rid = Rid;
		this.Mid = Mid;
		this.Uid = Uid;
		this.content = content;
		this.time = time;
	}
	
	public int getRid() {
		return Rid;
	}
	
	public void setRid(int Rid) {
		this.Rid = Rid;
	}
	
	public int getMid() {
		return Mid;
	}
	
	public void setMid(int Mid) {
		this.Mid = Mid;
	}
	
	public int getUid() {
		return Uid;
	}
	
	public void setUid(int Uid) {
		this.Uid = Uid;
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