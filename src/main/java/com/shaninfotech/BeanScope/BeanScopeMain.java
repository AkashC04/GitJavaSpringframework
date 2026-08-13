package com.shaninfotech.BeanScope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class BeanScopeMain {
public static void main(String []args) {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
	
	
	System.out.println("==========singleton scope demo===============");
	GlobalConfig config1 = context.getBean(GlobalConfig.class);
	GlobalConfig config2 = context.getBean(GlobalConfig.class);
	
	System.out.println("config 1 instance Id:"+ config1.getInstanceId());
	System.out.println("config2 instance Id:"+ config2.getInstanceId());
	System.out.println(" are u both config instance Id?"+(config1 == config2));
	
	System.out.println("=============protoType====================");
	UserTask task1 = context.getBean(UserTask.class);
	task1.setTaskName("generate report");
	
	UserTask task2 = context.getBean(UserTask.class);
	task2.setTaskName("send email");
	
	System.out.println("task 1 Id ["+ task1.getTaskName() +"]:"+ task1.getTaskId());
	System.out.println("task 2 Id ["+ task2.getTaskName() +"]:"+ task2.getTaskId());
    System.out.println("are both task instatce id?"+(task1 == task2));
    
	context.close();
	}
}
