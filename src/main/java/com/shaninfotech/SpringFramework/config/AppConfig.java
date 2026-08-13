package com.shaninfotech.SpringFramework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.shaninfotech.SpringFramework.SpringFramework.Car;
import com.shaninfotech.SpringFramework.SpringFramework.Engine;

@Configuration
@ComponentScan(basePackages = {
    "com.shaninfotech.SpringFramework.SpringFramework",
    "com.shaninfotech.injectionStyle",
    "com.shaninfotech.SpringFramework"
})
public class AppConfig {
	@Bean
         public Engine engine() {
        	 return new Engine();
         }
         @Bean
         public Car car() {
        	 return new Car(engine());
        	 
        	 
         }
}
