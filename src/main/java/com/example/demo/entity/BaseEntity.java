package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;

import lombok.Data;

@FilterDef(name="activeFilter")
@Filter(name="activeFilter", condition="is_active = true")
@MappedSuperclass
@Data
public class BaseEntity {
	private boolean isActive;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable=false)
	private Long id;
}
