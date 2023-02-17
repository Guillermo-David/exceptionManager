package com.guillermo.exception.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guillermo.exception.enums.ErrorCode;
import com.guillermo.exception.service.ServiceException;

@RestController
@RequestMapping("/json")
public class Controller {

	@GetMapping("/{code}")
	public String get(@PathVariable String code) {
		System.out.println("controller");
		ErrorCode response = ErrorCode.get(code);
		throw new ServiceException(HttpStatusCode.valueOf(response.getCode()), response.getMsg());
//		return "fin";
	}
	
}
