package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.EntityA;


public interface EntityARepo extends JpaRepository<EntityA, Long> {
	
}
