package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.EntityB;

public interface EntityBRepo extends JpaRepository<EntityB, Long> {

	@Query("SELECT b FROM EntityB b JOIN EntityA a ON a = b.a WHERE a.status = :status")
	public List<EntityB> findWithStatus(String status);
	
}
