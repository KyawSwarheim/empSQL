package com.emp.mydb.Empdb.response;

import java.io.Serializable;

public class DefaultReponse implements Serializable{
	
	private  String message= "Your Id is not found!";

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
