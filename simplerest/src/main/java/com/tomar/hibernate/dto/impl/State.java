package com.tomar.hibernate.dto.impl;

import com.tomar.hibernate.dto.CountryInterface;
import com.tomar.hibernate.dto.StateInterface;

public class State implements StateInterface {
	private Integer id;
	private String name;
	private String code;
	private CountryInterface country;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public CountryInterface getCountry() {
		return country;
	}
	public void setCountry(CountryInterface country) {
		this.country = country;
	}
}
