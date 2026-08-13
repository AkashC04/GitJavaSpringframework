package com.shaninfotech.BeanLifecycleScope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class PaymentConfig {
      @Bean
      public AuditService auditservice() {
    	  return new AuditService();
    	  
      }
      
      @Bean(initMethod = "setGateway", destroyMethod = " teardownGateway")
      @Scope("singleton")
      public PaymentGatewayService paymentgatwayservice() {
    	  return new PaymentGatewayService(auditservice());
    	  
      }
      
      
     
      
}
