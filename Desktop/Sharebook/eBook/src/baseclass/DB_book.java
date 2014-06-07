package baseclass;

public class DB_book {
	
	private int Bid;
	private String name;
	private String writer;
	private char type;
	private boolean state;
	private String label;
	private String mark;
	private String coverPath;
	private int Uid;
	private String time;
	
	public DB_book(int Bid,
			       String name,
			       String writer,
			       char type,
			       boolean state,	
			       String label,
			       String mark,
                   String coverPath,
			       int Uid,
			       String time) {
		this.Bid = Bid;
		this.name = name;
		this.writer = writer;
		this.type = type;
		this.state = state;
		this.label = label;
		this.mark = mark;
		this.coverPath = coverPath;
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
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getMark() {
		return mark;
	}
	
	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getCoverPath() {
		return coverPath;
	} 
	
	public void setCoverPath(String coverPath) {
		this.coverPath = coverPath;
	}
	
	public int getUid() {
		return Uid;
	}
	
	public void setUid(int Uid) {
		this.Uid = Uid;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
}