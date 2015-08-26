package com.tomar.hibernate.dto.impl;

import com.tomar.hibernate.dto.DTOErrorInterface;

public class DTOError implements DTOErrorInterface{
	private String message;
	public DTOError(String message){
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
