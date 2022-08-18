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

import com.example.demo.dto.CityDTO;
import com.example.demo.services.CityService;


@RestController
@RequestMapping("/citys")
public class CityResource {
	
	@Autowired
	private CityService cityService;
	
	@GetMapping
	public ResponseEntity<Page<CityDTO>> findPageable(Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(cityService.findPageable(pageable));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<CityDTO>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(cityService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CityDTO> findById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(cityService.findById(id));
	}

	@PostMapping
	public ResponseEntity<CityDTO> save(@RequestBody @Valid CityDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cityService.save(dto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<CityDTO> update(@PathVariable Long id, @RequestBody @Valid CityDTO dto) {
		return ResponseEntity.status(HttpStatus.OK).body(cityService.update(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		cityService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
