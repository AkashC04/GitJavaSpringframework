package com.shaninfotech.SpringFramework.DB;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="payment_txn")
public class PaymentEntity {
     @Id
     @Column(name = "txn_id")
     private String TransactionId;
     
     @ManyToOne
     @JoinColumn(name = "customer_id",nullable = false)
     private CustomerEntity customer;
     
    @Column(nullable = false)
    private BigDecimal amount;
    
    @Column(nullable = false)
private String status;
    
    protected PaymentEntity() {
    	
    }

	public PaymentEntity(String transactionId, CustomerEntity customer, BigDecimal amount, String status) {
		super();
		this.TransactionId = TransactionId;
		this.customer = customer;
		this.amount = amount;
		this.status = status;
	}

	public String getTransactionId() {
		return TransactionId;
	}

	public void setTransactionId(String TransactionId) {
		TransactionId = TransactionId;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
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

	@Override
	public String toString() {
		return "PaymentEntity [TransactionId=" + TransactionId + ", customer=" + customer + ", status=" + status + "]";
	}
	
}
