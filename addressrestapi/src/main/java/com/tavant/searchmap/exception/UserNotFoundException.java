package com.tavant.searchmap.exception;

public class UserNotFoundException  extends Exception{
	public UserNotFoundException(String msg) {
		super(msg);
		
	}

	@Override
	public String toString() {
		
		return super.toString()+ this.getMessage();
	}
	

}
