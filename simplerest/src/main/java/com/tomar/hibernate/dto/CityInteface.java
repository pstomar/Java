package com.tomar.hibernate.dto;

import com.tomar.hibernate.dto.impl.State;

public interface CityInteface {
	public Integer getId() ;
	public void setId(Integer id);
	public String getName();
	public void setName(String name);
	public State getState();
	public void setState(State state);
}
