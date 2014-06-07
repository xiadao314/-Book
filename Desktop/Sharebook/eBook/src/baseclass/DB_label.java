package baseclass;

public class DB_label {
	
	private int Lid;
	private String name;
	
	public DB_label(int Lid, String name)  {
		this.Lid = Lid;
		this.name = name;
	}
	
	public int getLid() {
		return Lid;
	}
	
	public void setLid(int Lid) {
		this.Lid = Lid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
};