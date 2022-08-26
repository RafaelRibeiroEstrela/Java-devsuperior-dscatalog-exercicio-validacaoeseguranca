package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CityDTO;
import com.example.demo.entities.City;
import com.example.demo.exceptions.ApiException;
import com.example.demo.repositories.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository repository;
	
	public Page<CityDTO> findPageable(Pageable pageable){
		return repository.findAll(pageable).map(city -> new CityDTO(city));
	}
	
	public List<CityDTO> findAll(){
		return repository.findAll()
				.stream().map(entity -> new CityDTO(entity)).collect(Collectors.toList());
	}
	
	public CityDTO findById(Long id) {
		return new CityDTO(
				repository.findById(id).orElseThrow(() -> new ApiException("Entity not found")));
		
	}
	
	public CityDTO save(CityDTO dto) {
		City entity = new City();
		copyDtoToEntity(entity, dto);
		return new CityDTO(repository.save(entity));
	}
	
	public CityDTO update(Long id, CityDTO dto) {
		City entity = repository.findById(id).orElseThrow(() -> new ApiException("Entity not found"));
		copyDtoToEntity(entity, dto);
		return new CityDTO(repository.save(entity));
	}
	
	public void delete(Long id){
		findById(id);
		repository.deleteById(id);
	}
	
	private void copyDtoToEntity(City entity, CityDTO dto) {
		entity.setName(dto.getName());
	}
	

}
