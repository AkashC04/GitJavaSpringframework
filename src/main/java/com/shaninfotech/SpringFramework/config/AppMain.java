package com.shaninfotech.SpringFramework.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shaninfotech.SpringFramework.SpringFramework.Car;

public class AppMain {
     public static void main(String [] args) {
    	 ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	 Car car= context.getBean(Car.class);
    	 car.drive();
     }
}
