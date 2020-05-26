package com.example.demo.filter;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.EntityA;
import com.example.demo.entity.EntityB;
import com.example.demo.repository.EntityARepo;
import com.example.demo.repository.EntityBRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class FilterTest {
	
	@Autowired
	private EntityBRepo bRepo;
	
	@Autowired
	private EntityARepo aRepo;
	
	@Autowired
	private EntityManager entityManager;

	@Test
	public void filterTest() {
		Session session = entityManager.unwrap(Session.class);
		session.enableFilter("activeFilter");
		
		// Generated Query: select * from entitya entitya0_ where entitya0_.is_active = true
		List<EntityA> as = aRepo.findAll();
		
		// Generated Query: select * from entityb bs0_ where true = bs0_.is_active and bs0_.a_id=?
		System.out.println(as.get(0).getBs().size());
		
		// Generated Query: select * from entityb entityb0_ inner join entitya entitya1_ on (entitya1_.id=entityb0_.a_id) where entityb0_.is_active = true and entitya1_.status=?
		List<EntityB> bs = bRepo.findWithStatus("pending");
	}
}
