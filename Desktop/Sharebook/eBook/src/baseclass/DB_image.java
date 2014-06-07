package baseclass;

public class DB_image {
	
	private int Iid;
	private String name;
	
	public DB_image(int Iid, String name)  {
		this.Iid = Iid;
		this.name = name;
	}
	
	public int getIid() {
		return Iid;
	}
	
	public void setIid(int Iid) {
		this.Iid = Iid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
};