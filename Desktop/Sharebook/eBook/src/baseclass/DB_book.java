package baseclass;

public class DB_book {
	
	private int Bid;
	private String name;
	private String writer;
	private char type;
	private boolean state;
	private int Lid;
	private String mark;
	private int Uid;
	private long time;
	
	public DB_book(int Bid,
			       String name,
			       String writer,
			       char type,
			       boolean state,			       
			       String mark,
			       int Lid,
			       int Uid,
			       long time) {
		this.Bid = Bid;
		this.name = name;
		this.writer = writer;
		this.type = type;
		this.state = state;
		this.mark = mark;
		this.Lid = Lid;
		this.Uid = Uid;
		this.time = time;
	}
	
	public int getBid() {
		return Bid;
	}
	
	public void setBid(int Bid) {
		this.Bid = Bid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public char getType() {
		return type;
	}
	
	public void setType(char type) {
		this.type = type;
	}
	
	public boolean getState() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
	
	public String getMark() {
		return mark;
	}
	
	public void setMark(String mark) {
		this.mark = mark;
	}

	public int getLid() {
		return Lid;
	}
	
	public void setLid(int Lid) {
		this.Lid = Lid;
	}
	
	public int getUid() {
		return Uid;
	}
	
	public void setUid(int Uid) {
		this.Uid = Uid;
	}
	
	public long getTime() {
		return time;
	}
	
	public void seTime(long time) {
		this.time = time;
	}
	
}