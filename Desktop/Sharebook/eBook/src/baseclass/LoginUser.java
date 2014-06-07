package baseclass;

public class LoginUser {
	private String name;
	private String pwd;
	public LoginUser(String a,String b)
	{
		name=a;
		pwd=b;
	}
	public void setName(String a)
	{
		name=a;
	}
	public void setPwd(String b)
	{
		pwd=b;
	}
	public String getName()
	{
		return this.name;
	}
	public String getPwd()
	{
		return this.pwd;
	}
}

