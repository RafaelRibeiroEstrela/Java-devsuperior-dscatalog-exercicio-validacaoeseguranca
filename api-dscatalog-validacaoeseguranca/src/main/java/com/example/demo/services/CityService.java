package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.CityDTO;
import com.example.demo.entities.City;
import com.example.demo.repositories.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository repository;
	
	public List<CityDTO> findAllSortedByName(){
		return repository.findAllSortedByName().stream()
				.map(city -> new CityDTO(city)).collect(Collectors.toList());
	}

	public CityDTO save(CityDTO dto) {
		City city = new City();
		copyDtoToEntity(dto, city);
		return new CityDTO(repository.save(city));
	}
	
	private void copyDtoToEntity(CityDTO dto, City entity) {
		entity.setName(dto.getName());
	}
	
}
