package com.guillermo.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class ControllerException extends ResponseStatusException {

	private static final long serialVersionUID = 1442990100598048553L;

	public ControllerException(int code, String reason) {
		super(HttpStatusCode.valueOf(code), reason);
	}

	public ControllerException(HttpStatusCode status, String reason) {
		super(status, reason);
	}
	
	public ControllerException(String code) {
		super(HttpStatusCode.valueOf(ErrorCode.get(code).getCode()), ErrorCode.get(code).getMsg());
	}

}
