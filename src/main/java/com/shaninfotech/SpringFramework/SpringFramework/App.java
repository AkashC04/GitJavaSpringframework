package com.shaninfotech.SpringFramework.SpringFramework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shaninfotech.SpringFramework.config.AppConfig;
import com.shaninfotech.injectionStyle.NotificationService;

public class App {

    public static void main(String[] args) {

      System.out.println("hello word");
       Engine engine = new Engine();
       Car car= new Car(engine);
     car.drive();
        
 	 ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
   Car car1 = context.getBean(Car.class);
     car1.drive();
     
     ApplicationContext context1 = new AnnotationConfigApplicationContext(AppConfig.class);
     Book book = context1.getBean(Book.class);
     book.bookDetails();

     ApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig.class);
     Vehical vehical = context2.getBean(Vehical.class);
     vehical.setVeh_no(2002);
     vehical.setVehName("supraaaaa");
     System.out.println(vehical.getVeh_no()+":"+ vehical.getVehName());
     
    	ApplicationContext context11 = new AnnotationConfigApplicationContext(AppConfig.class);

        NotificationService service = context11.getBean(NotificationService.class);

        service.notifyMessage();
    }
}
