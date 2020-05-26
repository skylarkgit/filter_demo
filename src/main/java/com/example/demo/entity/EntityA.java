package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Filter;

import lombok.Getter;

@Entity
@Getter
public class EntityA extends BaseEntity {
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "a_id")
	@Filter(name = "activeFilter", condition = "true = is_active")
	private List<EntityB> bs;

	private String status;
}
