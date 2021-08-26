package com.emp.mydb.Empdb.response;

import java.io.Serializable;

public class DefaultReponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String message;

	public DefaultReponse() {
	}

	public DefaultReponse(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
