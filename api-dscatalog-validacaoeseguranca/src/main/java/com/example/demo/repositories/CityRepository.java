package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.City;

public interface CityRepository extends JpaRepository<City, Long>{

}
