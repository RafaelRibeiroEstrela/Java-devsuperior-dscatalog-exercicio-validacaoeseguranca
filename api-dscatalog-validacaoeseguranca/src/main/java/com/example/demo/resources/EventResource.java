package com.example.demo.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EventDTO;
import com.example.demo.services.EventService;


@RestController
@RequestMapping("/events")
public class EventResource {
	
	@Autowired
	private EventService eventService;
	
	@GetMapping
	public ResponseEntity<Page<EventDTO>> findPageable(Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(eventService.findPageable(pageable));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<EventDTO>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(eventService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<EventDTO> findById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(eventService.findById(id));
	}

	@PostMapping
	public ResponseEntity<EventDTO> save(@RequestBody @Valid EventDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(eventService.save(dto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<EventDTO> update(@PathVariable Long id, @RequestBody @Valid EventDTO dto) {
		return ResponseEntity.status(HttpStatus.OK).body(eventService.update(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		eventService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
