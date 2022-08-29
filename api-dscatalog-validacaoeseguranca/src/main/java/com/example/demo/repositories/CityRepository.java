package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.City;

public interface CityRepository extends JpaRepository<City, Long>{
	
	@Query("SELECT ci FROM City ci ORDER BY ci.name ASC")
	List<City> findAllSortedByName();

}
