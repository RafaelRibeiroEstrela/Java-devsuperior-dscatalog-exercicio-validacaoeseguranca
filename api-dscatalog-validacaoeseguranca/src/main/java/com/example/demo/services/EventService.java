package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EventDTO;
import com.example.demo.entities.City;
import com.example.demo.entities.Event;
import com.example.demo.exceptions.ApiException;
import com.example.demo.repositories.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository repository;
	
	public Page<EventDTO> findPageable(Pageable pageable){
		return repository.findAll(pageable)
				.map(entity -> new EventDTO(entity));
	}
	
	public List<EventDTO> findAll(){
		return repository.findAll()
				.stream().map(entity -> new EventDTO(entity)).collect(Collectors.toList());
	}
	
	public EventDTO findById(Long id) {
		return new EventDTO(
				repository.findById(id).orElseThrow(() -> new ApiException("Entity not found")));
		
	}
	
	public EventDTO save(EventDTO dto) {
		Event entity = new Event();
		
		copyDtoToEntity(entity, dto);
		return new EventDTO(repository.save(entity));
	}
	
	public EventDTO update(Long id, EventDTO dto) {
		Event entity = repository.findById(id).orElseThrow(() -> new ApiException("Entity not found"));
		copyDtoToEntity(entity, dto);
		return new EventDTO(repository.save(entity));
	}
	
	public void delete(Long id){
		findById(id);
		repository.deleteById(id);
	}
	
	private void copyDtoToEntity(Event entity, EventDTO dto) {
		entity.setName(dto.getName());
		entity.setDate(dto.getDate());
		entity.setUrl(dto.getUrl());
		City city = new City();
		city.setId(dto.getCityId());
		entity.setCity(city);
	}
	

}
