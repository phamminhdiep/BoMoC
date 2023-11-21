package com.example.BoMoC.Model.User;

import java.util.Date;

public class User {
	private int id;
	private FullName fullName;
	private Address address;
	private Account account;
	private String email;
	private Date dob;
	private boolean gender;
	private String phoneNumber;
	public Account unnamed_Account_;
	public FullName unnamed_FullName_;
	public Address unnamed_Address_;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FullName getFullName() {
		return fullName;
	}

	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Account getUnnamed_Account_() {
		return unnamed_Account_;
	}

	public void setUnnamed_Account_(Account unnamed_Account_) {
		this.unnamed_Account_ = unnamed_Account_;
	}

	public FullName getUnnamed_FullName_() {
		return unnamed_FullName_;
	}

	public void setUnnamed_FullName_(FullName unnamed_FullName_) {
		this.unnamed_FullName_ = unnamed_FullName_;
	}

	public Address getUnnamed_Address_() {
		return unnamed_Address_;
	}

	public void setUnnamed_Address_(Address unnamed_Address_) {
		this.unnamed_Address_ = unnamed_Address_;
	}
}