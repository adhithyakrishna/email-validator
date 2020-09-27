package com.validator.shared;

import java.io.Serializable;

public class ResponseDTO implements Serializable {

	/*
	 * used for user information transfer between different layers DTO conforms to
	 * design pattern hence serializable
	 */
	private static final long serialVersionUID = -2581667655514785416L;

	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
