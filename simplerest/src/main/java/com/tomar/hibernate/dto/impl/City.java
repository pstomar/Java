package com.tomar.hibernate.dto.impl;

import com.tomar.hibernate.dto.CityInteface;

public class City implements CityInteface{
	private Integer id;
	private String name;
	private State state;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}

}
