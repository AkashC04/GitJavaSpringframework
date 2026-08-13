package com.shaninfotech.SpringFramework.DB;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
       private final CustomerRepository customerRepository;

	   public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	   }
       @Transactional
       public void registerCustomer (CustomerEntity customer) {
    	   if (!customerRepository.existById(customer.getCustomerId())){
    		   customerRepository.save(customer);
    	   }
       }	  
    @Transactional(readOnly = true)
    public CustomerEntity getCustomer (String customerId) {
    	return customerRepository.findById(customerId);
    	
    }
    @Transactional(readOnly = true)
public List<CustomerEntity> getAllCustomer(){
    	return customerRepository.findAll();
    	
    }
    @Transactional
    public void updateCustomer(CustomerEntity customer) {
    customerRepository.update(customer);
    
    }
    @Transactional
    public void removeCustomer(String customerId) {
    	customerRepository.deleteById(customerId);
    }
    @Transactional(readOnly = true)
public boolean exists(String customerId) {
    	return customerRepository.existById(customerId);
    			
    		
    }
    
       }
       

