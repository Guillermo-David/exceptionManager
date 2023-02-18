package com.guillermo.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class ServiceException extends ResponseStatusException {

	private static final long serialVersionUID = 1250950619708926026L;
	
	public ServiceException(int code, String reason) {
		super(HttpStatusCode.valueOf(code), reason);
	}

	public ServiceException(HttpStatusCode status, String reason) {
		super(status, reason);
	}
	
	public ServiceException(String code) {
		super(HttpStatusCode.valueOf(ErrorCode.get(code).getCode()), ErrorCode.get(code).getMsg());
	}

}
