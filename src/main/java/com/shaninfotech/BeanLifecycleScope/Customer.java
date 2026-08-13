package com.shaninfotech.BeanLifecycleScope;

public class Customer {
        private String  customerId;
        private String Name;
        private String city;
        private String AccountNumber;
		public Customer(String customerId, String name, String city, String accountNumber) {
			super();
			this.customerId = customerId;
			this.Name = name;
			this.city = city;
			this.AccountNumber = accountNumber;
		}
		public String getCustomerId() {
			return customerId;
		}
		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getAccountNumber() {
			return AccountNumber;
		}
		public void setAccountNumber(String accountNumber) {
			AccountNumber = accountNumber;
		}
		@Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", Name=" + Name + ", city=" + city + ", AccountNumber="
					+ AccountNumber + "]";
		}
		
	
        
        
        
        
}
