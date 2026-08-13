package com.shaninfotech.BeanLifecycleScope;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class LifeCycleLoggingBeanPostProcessor implements BeanPostProcessor{
    public Object postProcessBeforeInitialisation(Object bean,String beanName) throws BeansException{
    	System.out.println("[]BeanPostProcessor]  before initialisaiton of "+ beanName +"'");
    
    return bean;
    
}

public Object postProcessAfterInitialisation(Object bean,String beanName)throws BeansException{
	if (bean instanceof PaymentGatewayService) {
    	System.out.println("[]BeanPostProcessor]  after initialisaiton of "+ beanName +"'");

	}
	return bean;
}
}