package com.bogdand.SpringHibernateX;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class Exceptions extends RuntimeException{
	public Exceptions() {
		super();
	}
	public Exceptions(String message) {
		super(message);
	}
	public Exceptions(String message, Throwable cause) {
		super(message,cause);
	}
	
}
