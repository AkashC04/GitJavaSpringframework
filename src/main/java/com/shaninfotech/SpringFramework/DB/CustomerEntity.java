package com.shaninfotech.SpringFramework.DB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table(name="customer")
	public class CustomerEntity {
		
		@Id
		@Column(name="customer_id")
		private String customerId;
		
		@Column(nullable=false)
		private String name;
		
		@Column (nullable=false)
		private String city;
		
		@Column(name="account_number",nullable=false)
		private String accountNumber;
		
		protected CustomerEntity() {
			
		}

		public CustomerEntity(String customerId, String name, String city, String accountNumber) {
			super();
			this.customerId = customerId;
			this.name = name;
			this.city = city;
			this.accountNumber = accountNumber;
		}

		public String getCustomerId() {
			return customerId;
		}

		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}

		@Override
		public String toString() {
			return "CustomerEntity [customerId=" + customerId + ", name=" + name + ", city=" + city + ", accountNumber="
					+ accountNumber + "]";
		}
		

	}

