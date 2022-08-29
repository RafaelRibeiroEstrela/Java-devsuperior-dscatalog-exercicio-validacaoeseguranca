package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.EventDTO;
import com.example.demo.entities.City;
import com.example.demo.entities.Event;
import com.example.demo.repositories.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository repository;
	
	public Page<EventDTO> findAll(Pageable pageable){
		return repository.findAll(pageable).map(event -> new EventDTO(event));
	}

	public EventDTO save(EventDTO dto) {
		Event event = new Event();
		copyDtoToEntity(dto, event);
		return new EventDTO(repository.save(event));
	}
	
	private void copyDtoToEntity(EventDTO dto, Event entity) {
		entity.setName(dto.getName());
		entity.setUrl(dto.getUrl());
		entity.setDate(dto.getDate());
		City city = new City();
		city.setId(dto.getCityId());
		entity.setCity(city);
	}

}
