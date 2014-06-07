package baseclass;

public class DB_message {
	
	private int Mid;
	private int Uid;
	private int Bid;
	private String content;
	private int goodNum;
	private int replyNum;
	private long time;
	
	public DB_message(int Mid,
			          int Uid,
			          int Bid, 
			          String content,
			          int goodNum,
			          int replyNum,
			          long time) {
		this.Mid = Mid;
		this.Uid = Uid;
		this.Bid = Bid;	
		this.content = content;
		this.goodNum = goodNum;
		this.replyNum = replyNum;
		this.time = time;
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
	
	public int getBid() {
		return Bid;
	}
	
	public void setBid(int Bid) {
		this.Bid = Bid;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this. content = content;
	}
	
	public int getGoodNum() {
		return goodNum;
	}
	
	public void setGood(int goodNum) {
		this.goodNum = goodNum;
	}
	
	public int getReplyNum() {
		return replyNum;
	}
	
	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}
	
	public long getTime() {
		return time;
	}
	
	public void setTime(long time) {
		this.time = time;
	}
}