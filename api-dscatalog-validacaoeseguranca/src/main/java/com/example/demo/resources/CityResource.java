package com.example.demo.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.CityDTO;
import com.example.demo.services.CityService;

@RestController
@RequestMapping("/cities")
public class CityResource {
	
	@Autowired
	private CityService service;
	
	@GetMapping
	public ResponseEntity<List<CityDTO>> findAllSortedByName(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAllSortedByName());
	}
	
	@PostMapping
	public ResponseEntity<CityDTO> save(@RequestBody @Valid CityDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
	}

}
