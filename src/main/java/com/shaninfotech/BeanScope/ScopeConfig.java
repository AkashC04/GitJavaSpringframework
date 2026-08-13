package com.shaninfotech.BeanScope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScopeConfig {
         @Bean
         @Scope("prototype")
         public GlobalConfig globalConfig() {
        	 GlobalConfig config = new GlobalConfig();
        	 config.setAppName("Sprimgdemoapp");
        	 return config;
        	 
         }
         @Bean
         @Scope("singleton")
         public UserTask usertask() {
        	 return new UserTask();
        	 
         }
}
