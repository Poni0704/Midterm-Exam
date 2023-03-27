package tw.com.eeit.badminton.model.bean;

import java.io.Serializable;

public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String username;
	private String password;
	private String isAdmin;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", username=" + username + ", password=" + password + ", isAdmin=" + isAdmin + "]";
	}

	public Member(int id, String username, String password, String level) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.isAdmin = level;
	}

	public Member(String username, String password, String level) {
		super();
		this.username = username;
		this.password = password;
		this.isAdmin = level;
	}

	public Member(String level) {
		super();
		this.isAdmin = level;
	}

	public Member(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

}
