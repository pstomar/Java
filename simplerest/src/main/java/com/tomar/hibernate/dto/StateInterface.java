package com.tomar.hibernate.dto;


public interface StateInterface {
	public Integer getId();
	public void setId(Integer id);
	public String getName();
	public void setName(String name);
	public String getCode();
	public void setCode(String code);
	public CountryInterface getCountry();
	public void setCountry(CountryInterface country);

}
