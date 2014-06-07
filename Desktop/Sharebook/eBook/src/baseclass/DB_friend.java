package baseclass;

public class DB_friend {
	
	private int Fid;
	private int hostUid;
	private int friendUid;
	
	public DB_friend(int Fid, int hostUid, int friendUid) {
		this.Fid = Fid;
		this.hostUid = hostUid;
		this.friendUid = friendUid;
	}
	
	public int getFid() {
		return Fid;
	}
	
	public void setFid(int Fid) {
		this.Fid = Fid;
	}
	
	public int getHostUid() {
		return hostUid;
	}
	
	public void setHostUid(int hostUid) {
		this.hostUid = hostUid;
	}
	
	public int getFriendUid() {
		return friendUid;
	}
	
	public void setFriendUid(int friendUid) {
		this.friendUid = friendUid;
	}
	
}