package tw.com.eeit.badminton.model.bean;

import java.io.Serializable;

public class MemberDetail implements Serializable {


	private static final long serialVersionUID = 1L;

	
	private int id;
	private String username;
	private String gender;
	private int age;
	private String birth;
	private int phone;
	private String address;
	private String email;
	private String photo;
	
	
	public MemberDetail() {
		super();
	}


	public MemberDetail(int id, String username, String gender, int age, String birth, int phone, String address,
			String email, String photo) {
		super();
		this.id = id;
		this.username = username;
		this.gender = gender;
		this.age = age;
		this.birth = birth;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.photo = photo;
	}


	public MemberDetail(String username, String gender, int age, String birth, int phone, String address, String email,
			String photo) {
		super();
		this.username = username;
		this.gender = gender;
		this.age = age;
		this.birth = birth;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.photo = photo;
	}


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


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getBirth() {
		return birth;
	}


	public void setBirth(String birth) {
		this.birth = birth;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	@Override
	public String toString() {
		return "MemberDetail [id=" + id + ", username=" + username + ", gender=" + gender + ", age=" + age + ", birth="
				+ birth + ", phone=" + phone + ", address=" + address + ", email=" + email + ", photo=" + photo + "]";
	}
	
	
	
}
