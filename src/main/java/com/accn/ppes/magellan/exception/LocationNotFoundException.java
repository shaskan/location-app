package com.accn.ppes.magellan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LocationNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public LocationNotFoundException() {
		super("No such Location:");
	}
	public LocationNotFoundException(Long locationNumber) {
		super("No such Location: " + locationNumber);
	}
}
