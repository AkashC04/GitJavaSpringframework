package com.shaninfotech.BeanLifecycleScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class PaymentGatewayService  implements BeanNameAware, ApplicationContextAware,DisposableBean{
	
	private final AuditService auditservice;
	private String BeanName;
	private Boolean connected;
	
	
	public PaymentGatewayService(AuditService auditservice) {	
		this.auditservice = auditservice;
		System.out.println("1.constructor :paymentservicegateway instace created");
	}


	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
	
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("3. setApplicationContext: container reference injucted");
	}


	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		this.BeanName = name;
		
	}
	@PostConstruct
	public void init() {
		System.out.println("4. postconstruct : annotation based intialisation");
	}
	
	public void AfterPropertiesSet() {
		System.out.println("5. setipgateway : gateway is not connected");
	}
	
public void ProcessPayment(PaymentTransaction transaction) {
	 if(! connected) {
		 throw new IllegalStateException("gateway not Inisitilised");
		 
	 }
	 
	 transaction.markCompleted();
	 
	 auditservice.record("Processed"+ transaction.getTransactionId()+"of rs."+transaction.getAmount()+"for"+transaction.getCustomer().getName());
	 System.out.println(">> "+ transaction);
}

@PreDestroy
public void CleanUp() {
	System.out.println("predestroy : cleanup ");
}

public void Destroy() {
	System.out.println("destroy: disposable bean caallback");
}

public void tearDowngateway() {
	this.connected=false;
	System.out.println("teardowngateway : gateway disconneted");
}

}
