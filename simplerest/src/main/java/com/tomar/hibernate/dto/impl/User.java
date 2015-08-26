package com.tomar.hibernate.dto.impl;

import com.tomar.hibernate.dto.CityInteface;
import com.tomar.hibernate.dto.UserInterface;

public class User implements UserInterface {
	private Integer userid;
	private String username;
	private String password;
	private String email;
	private String contact;
	private CityInteface city;
	private State state;
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public CityInteface getCity() {
		return city;
	}
	public void setCity(CityInteface city) {
		this.city = city;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
}
