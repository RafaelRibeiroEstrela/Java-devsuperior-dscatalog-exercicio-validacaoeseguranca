package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.example.demo.entities.City;

public class CityDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotBlank(message = "City name is required")
	private String name;
	
	public CityDTO() {
		
	}

	public CityDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public CityDTO(City city) {
		this.id = city.getId();
		this.name = city.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
