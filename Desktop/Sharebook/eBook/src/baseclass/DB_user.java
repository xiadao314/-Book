package baseclass;
public class DB_user {
	
	private int Uid;
	private String nickname;
	private String password;
	private String name;
	private char sex;
	private int age;
	private String school;
	private long phone;
	private String mark;
	private int Iid;
	private int Lid;
	private String time;
	private boolean state;
	private boolean authority;	
	
	public DB_user(int Uid, 
			       String nickname,
			       String password,
				   String name,
			       char sex,
			       int age,
			       String school,
			       long phone,
			       String mark,
			       int Iid,
			       int Lid,
			       String time,
			       boolean state,
			       boolean authority) {
		this.Uid = Uid;
		this.nickname = nickname;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.school = school;
		this.phone = phone;		
		this.mark = mark;
		this.Iid = Iid;
		this.Lid = Lid;
		this.time = time;
		this.state = state;
		this.authority = authority;
	}
	
	public int getUid() {
		return Uid;
	}
	
	public void setUid(int Uid) {
		this.Uid = Uid;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickmame(String nickname) {
		this.nickname = nickname;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public char getSex() {
		return sex;
	}
	
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getSchool() {
		return school;
	}
	
	public void setSchool(String school) {
		this.school = school;
	}
	
	public long getPhone() {
		return phone;
	}
	
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	public String getMark() {
		return mark;
	}
	
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	public int getIid() {
		return Iid;
	}
	
	public void setIid(int Iid) {
		this.Iid = Iid;
	}
	
	public int getLid() {
		return Lid;
	}
	
	public void setLid(int Lid) {
		this.Lid = Lid;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public boolean getState() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
	
	public boolean getAuthority() {
		return authority;
	}
	
	public void setAuthority(boolean authority) {
		this.authority = authority;
	}
}