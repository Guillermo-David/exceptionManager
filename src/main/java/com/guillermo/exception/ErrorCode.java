package com.guillermo.exception;

import java.io.File;
import java.nio.file.Paths;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorCode {
		
	private String msg;
	private Integer code;

		
	public static ErrorCode get(String key) {		
		
		ErrorCode response = new ErrorCode();
		
		try {
			
			File file = Paths.get(ClassLoader.getSystemResource("ErrorCode.json").toURI()).toFile();
			@SuppressWarnings("unchecked")
			Map<String, Map<String, Object>> responseMap = new ObjectMapper().readValue(file, Map.class);
			
			Map<String, Object> map = responseMap.get(key);
			
			if(response != null) {
				response.setCode(Integer.parseInt(map.get("code").toString()));
				response.setMsg(map.get("msg").toString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.setMsg("Unknown ErrorCode");
			response.setCode(500);
		}
		
		return response;
	}

}
