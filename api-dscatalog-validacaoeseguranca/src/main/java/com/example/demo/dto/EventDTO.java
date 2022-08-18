package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.example.demo.entities.City;
import com.example.demo.entities.Event;

public class EventDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private LocalDate date;

	private String url;

	private City city;
	
	public EventDTO() {
		
	}

	public EventDTO(Long id, String name, LocalDate date, String url, City city) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.url = url;
		this.city = city;
	}
	
	public EventDTO(Event event) {
		this.id = event.getId();
		this.date = event.getDate();
		this.name = event.getName();
		this.url = event.getUrl();
		this.city = event.getCity();
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	

}
