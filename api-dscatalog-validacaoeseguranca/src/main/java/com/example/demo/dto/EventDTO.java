package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.example.demo.entities.Event;

public class EventDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = "Event name is required")
	private String name;
	
	@Past(message = "The date cannot be in the past")
	private LocalDate date;

	private String url;

	@NotNull(message = "City is required")
	private Long cityId;
	
	public EventDTO() {
		
	}

	public EventDTO(Long id, String name, LocalDate date, String url, Long cityId) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.url = url;
		this.cityId = cityId;
	}
	
	public EventDTO(Event event) {
		this.id = event.getId();
		this.date = event.getDate();
		this.name = event.getName();
		this.url = event.getUrl();
		this.cityId = event.getCity().getId();
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	
	
	

}
