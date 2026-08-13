package com.shaninfotech.SpringFramework.DB;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository {
  @PersistenceContext
  private EntityManager entitymanager;
  
  
  public void save (PaymentEntity txn) {
	  entitymanager.persist(txn);
  }
  
  public PaymentEntity findById(String txnId) {
	  return entitymanager.find(PaymentEntity.class, txnId);
	  
  }
  public List<PaymentEntity>findAll(){
	  return entitymanager.createQuery("select t from PaymentEntity t order by t.TransactionId",PaymentEntity.class
			  
			  ).getResultList();
  }
  
  public List<PaymentEntity>findByCustomerId(String customerId){
	  return entitymanager.createQuery("select  t from PaymentEntity from t"+"where t.customer.customerId =:cid order by t.transactionId",PaymentEntity.class).setParameter("cid",customerId).getResultList();
	  
  }
  
  public PaymentEntity update (PaymentEntity txn) {
	  return entitymanager.merge(txn);
	  
  }
  public void deleteById(String txnId) {
	  PaymentEntity txn = entitymanager.find(PaymentEntity.class, txnId);
	  
  }
  
  public long count() {
	  return entitymanager.createQuery("select count(t) from PaymentEntity t",long.class).getSingleResult();
  }
}


