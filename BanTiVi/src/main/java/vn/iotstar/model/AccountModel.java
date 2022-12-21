package vn.iotstar.model;

public class AccountModel {
	private int uid;
	private String user;
	private String pass;
	private int isAdmin;
	
	@Override
	public String toString() {
		return "AccountModel [uid=" + uid + ", user=" + user + ", pass=" + pass + ", isAdmin="
				+ isAdmin + "]";
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public AccountModel() {
		super();
	}

	public AccountModel(int uid, String user, String pass, int isAdmin) {
		super();
		this.uid = uid;
		this.user = user;
		this.pass = pass;
		this.isAdmin = isAdmin;
	}
	
	
}
