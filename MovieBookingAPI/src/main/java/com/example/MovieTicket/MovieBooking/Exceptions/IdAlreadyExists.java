package com.example.MovieTicket.MovieBooking.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdAlreadyExists extends RuntimeException{

	public IdAlreadyExists(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
