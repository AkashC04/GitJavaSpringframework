package com.shaninfotech.BeanLifecycleScope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shaninfotech.BeanScope.ScopeConfig;

public class ScopeMainApp {
     public static void main(String [] args) {
    	 System.out.println("============starting container=============");
    		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
        System.out.println("========== singleton scope=============");
        
        PaymentGatewayService gateway1 = context.getBean(PaymentGatewayService.class);
        PaymentGatewayService gateway2 = context.getBean(PaymentGatewayService.class);
        System.out.println("gateway 1 hashcode :"+ System.identityHashCode(gateway1));
        System.out.println("gateway 2 hashcode :"+ System.identityHashCode(gateway2));
         
         System.out.println("========== prototype scope=============");
         PaymentTransaction txn1 = context.getBean(PaymentTransaction.class);
         PaymentTransaction txn2 = context.getBean(PaymentTransaction.class);
         System.out.println("txn1 hashcode :"+System.identityHashCode(txn1));
         System.out.println("txn2 hashcode :"+System.identityHashCode(txn2));
         
         System.out.println(" same instace?"+ (txn1 == txn2));
         System.out.println("=========processing payment===========");
         Customer akash = new Customer("101","akash","bngle","SB101");
         Customer var = new Customer("101","akash","bngle","SB101");
         Customer varun = new Customer("101","akash","bngle","SB101");


txn1.getCustomer();
txn2.getTransactionId();

         
     }
}
