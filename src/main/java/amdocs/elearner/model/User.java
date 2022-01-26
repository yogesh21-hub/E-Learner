package amdocs.elearner.model;

import java.util.Date;

public class User {
	private int user_id;
	private String name;
	private long phone;
	private String email;
	private String address;
	private String password;
	private Date date;
	
	public User(int user_id, String name, long phone, String email, String address, String password, Date date) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.password = password;
		this.date = date;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

}
