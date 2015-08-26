package com.tomar.hibernate.dto;

import com.tomar.hibernate.dto.impl.State;

public interface UserInterface {
	
	public Integer getUserid() ;
	public void setUserid(Integer userid) ;
	public String getUsername() ;
	public void setUsername(String username);
	public String getPassword() ;
	public void setPassword(String password);
	public String getEmail() ;
	public void setEmail(String email);
	public String getContact() ;
	public void setContact(String contact);
	public CityInteface getCity() ;
	public void setCity(CityInteface city);
	public State getState();
	public void setState(State state);
	
}
