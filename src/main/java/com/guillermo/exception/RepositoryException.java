package com.guillermo.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class RepositoryException extends ResponseStatusException {

	
	private static final long serialVersionUID = -2762636001378391018L;

	public RepositoryException(int code, String reason) {
		super(HttpStatusCode.valueOf(code), reason);
	}

	public RepositoryException(HttpStatusCode status, String reason) {
		super(status, reason);
	}
	
	public RepositoryException(String code) {
		super(HttpStatusCode.valueOf(ErrorCode.get(code).getCode()), ErrorCode.get(code).getMsg());
	}

}
