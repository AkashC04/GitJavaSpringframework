package com.shaninfotech.SpringFramework.DB;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository

public class CustomerRepository {
	@PersistenceContext
	
	private EntityManager entitymanager;
	
	public void save(CustomerEntity customer) {
		entitymanager.persist(customer);
		
	}
	
	public CustomerEntity findById(String customerId) {
		return entitymanager.find(CustomerEntity.class,customerId);
		
	}
	public List<CustomerEntity>findAll(){
		return entitymanager.createQuery("select c from CustomerEntity c order by c.customerId", CustomerEntity.class).getResultList();
		
	}
	
	public CustomerEntity update(CustomerEntity customer) {
		return entitymanager.merge(customer);
		
	}
	public void deleteById(String customerId) {
		CustomerEntity customer = entitymanager.find(CustomerEntity.class,customerId);
		
	}
	public boolean existById(String customerId) {
		return entitymanager.find(CustomerEntity.class,customerId)!= null;
	}
}
