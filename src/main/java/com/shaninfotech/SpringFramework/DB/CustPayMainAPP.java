package com.shaninfotech.SpringFramework.DB;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustPayMainAPP {
public static void main(String[] args) {

AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PaymentJPAConfig.class);
CustomerService customerService = context.getBean(CustomerService.class);
PaymentService paymentService = context.getBean(PaymentService.class);
        
CustomerEntity akash = new CustomerEntity("C101", "Akash", "Bangalore", "ACC1001");
CustomerEntity rahul = new CustomerEntity("C102", "rahul", "manglore", "ACC1002");
        
 System.out.println("============registerd customer==================");
   customerService.registerCustomer(akash);
   customerService.registerCustomer(rahul);

 System.out.println("============processing payment=====================");
    PaymentEntity p1 = new PaymentEntity("txn101",akash,new BigDecimal("1500.00"),"sucess");
    PaymentEntity p2 = new PaymentEntity("txn101",rahul,new BigDecimal("1600.00"),"success");
    PaymentEntity p3 = new PaymentEntity("txn101",akash,new BigDecimal("1700.00"),"pending");
     
        System.out.println("============ Read All Payments ============");
        List<PaymentEntity> payments = paymentService.getAllPayments();
for (PaymentEntity payment : payments) {
      System.out.println(payment);
        }
        
  System.out.println("==========find payments ==========");
  System.out.println(paymentService.getPayment("txn102"));
        
  System.out.println("========== update payments ==========");
  PaymentEntity payment = paymentService.getPayment("txn103");
   payment.setStatus("success");
   paymentService.updatePayment(payment);
  System.out.println(paymentService.getPayment("txn103"));
        
  System.out.println("====== payments of customerC101 ======");
      List<PaymentEntity> customerPayments =
         paymentService.getPaymentsByCustomer("C101");

 for (PaymentEntity txn : customerPayments) {
            System.out.println(txn);
        }
  System.out.println("==========count payments================");
        System.out.println("total Payments : "+ paymentService.totalPayments());
        
        
   System.out.println("===============Deleting txn102================");
    paymentService.removePayment("TXN102");
   System.out.println("Payments after deletion:");
    paymentService.getAllPayments().forEach(System.out::println);
 context.close();

	}
}