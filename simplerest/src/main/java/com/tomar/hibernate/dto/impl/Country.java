package com.tomar.hibernate.dto.impl;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.tomar.hibernate.dto.CountryInterface;

@XmlRootElement(name="countries")
public class Country implements CountryInterface {
	private Integer id;
	private String name;
	private String code;
	
	@XmlElement
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
