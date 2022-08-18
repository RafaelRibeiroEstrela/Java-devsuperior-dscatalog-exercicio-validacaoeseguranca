package com.example.demo.exceptions;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StandardError implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime time;
	private Integer status;
	private String error;
	private String path;
	private Map<String, String> fieldsErrros = new HashMap<>();
	
	public StandardError() {
		
	}

	public StandardError(LocalDateTime time, Integer status, String error, String path) {
		super();
		this.time = time;
		this.status = status;
		this.error = error;
		this.path = path;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Map<String, String> getFieldsErrros() {
		return fieldsErrros;
	}
	
	

}
