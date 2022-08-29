package com.example.demo.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.EventDTO;
import com.example.demo.services.EventService;

@RestController
@RequestMapping("/events")
public class EventResource {
	
	@Autowired
	private EventService service;
	
	@GetMapping
	public ResponseEntity<Page<EventDTO>> findAll(Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
	}
	
	@PostMapping
	public ResponseEntity<EventDTO> save(@RequestBody @Valid EventDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
	}

}
