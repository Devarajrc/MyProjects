package com.demoAPI.rest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEMO_USER")
public class UserEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_REF")
	private int userRef;
	
	@Column(name="FNAME")
	private String fname;
	
	
	@Column(name="PASSWORD")
	private String pwd;
	
	@Column(name="LNAME")
	private String lname;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="MOBILE_NO")
	private String mobileNo;
	
	@Column(name="EMAIL_ID")
	private String emailId;
	


	
	

	@Column(name="DOB")
	private Date dob;
	
	@Column(name="REG_DATE")
	private Date date;
	
	
	

	@Column(name="COUNTRY")
	private String country;
	

	@Column(name="STATE")
	private String state;
	
	
	@Column(name="GENDER")
	private String gender;
	
/*
	@Column(name="LOGIN_STATUS")
	private String loginStatus;
	@Column(name="LAST_LOGIN_TIME")
	private Date lastlogin;
	
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	public Date getLastlogin() {
		return lastlogin;
	}
	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}
	
	*/
	
	
public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getUserRef() {
		return userRef;
	}
	public void setUserRef(int userRef) {
		this.userRef = userRef;
	}
	
	public String getName() {
		return fname;
	}
	public void setName(String fname) {
		this.fname = fname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
