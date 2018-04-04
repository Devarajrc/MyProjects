package com.demoAPI.rest.dto.request;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

public class RequestDTO implements Serializable{

	
	private String address;
	private String mobileNo;
	private String emailId;
	private String pwd;

	
	private String fname;
	
	
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	private String lname;
	
	
	
	
	
	
	
	
	
	//private String userPwd;

	
	

	
	private Date dob;
	

	private Date date;
	
	
	

	
	private String country;

	private String state;
	private String gender;

	
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
