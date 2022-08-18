package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}
