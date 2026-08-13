package com.shaninfotech.BeanLifecycleScope;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PaymentTransaction {
	
	private static final AtomicInteger COUNTER = new AtomicInteger(1000);
	
       private final String transactionId;
       private Customer customer;
       private BigDecimal amount;
       private String status;
       
       
	   public PaymentTransaction(String transactionId, Customer customer, BigDecimal amount, String status) {
		super();
		this.transactionId = transactionId;
		this.customer = customer;
		this.amount = amount;
		this.status = status;
		
	   }
	   
	   @PostConstruct
	   public void init() {
		   System.out.println("   postconstruct on "+ transactionId);
		   
	   }
	   @PreDestroy
	   public void cleanUp() {
		   System.out.println("    predestroy on"+ transactionId);
		   
	   }
	   public Customer getCustomer() {
		   return customer;
	   }
	   public void setCustomer(Customer customer) {
		   this.customer = customer;
	   }
	   public BigDecimal getAmount() {
		   return amount;
	   }
	   public void setAmount(BigDecimal amount) {
		   this.amount = amount;
	   }
	   public String getStatus() {
		   return status;
	   }
	   public void setStatus(String status) {
		   this.status = status;
	   }
	   public String getTransactionId() {
		   return transactionId;
	   }
	   @Override
	   public String toString() {
		return "PaymentTransaction [transactionId=" + transactionId + ", customer=" + customer + ", amount=" + amount
				+ ", status=" + status + "]";
	   }

	   public void markCompleted() {
		// TODO Auto-generated method stub
		
	   }
       
       
       
}
