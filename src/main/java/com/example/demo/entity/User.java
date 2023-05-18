package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid")
	private int userid ;
	
	@Column(name="username")
	private String username ;
	
	@Column(name="email", unique = true, nullable = false)
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="gender")
	private String gender;

	@Column(name="privilege", columnDefinition="int default 0")
	private int privilege;
	
	@OneToMany(mappedBy="user")
	private List<Comment> comments;
	
	@OneToMany(mappedBy = "user")
	private List<Recipe> recipes;
	
//	public User() {
//		
//	}
//	public User(int userid, String username, String email, String password) {
//		this.userid = userid;
//		this.username = username;
//		this.email = email;
//		this.password = password;
//	}
	
	public int getUserid() {
		return userid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userid, String username, String email, String password, String mobile, String gender, int privilege,
			List<Comment> comments, List<Recipe> recipes) {
		super();
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.gender = gender;
		this.privilege = privilege;
		this.comments = comments;
		this.recipes = recipes;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getPrivilege() {
		return privilege;
	}
	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", mobile=" + mobile + ", gender=" + gender + ", privilege=" + privilege + ", comments=" + comments
				+ ", recipes=" + recipes + "]";
	}
	
	
	
	
	
	

}
