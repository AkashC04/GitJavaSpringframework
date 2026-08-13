package com.shaninfotech.injectionStyle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {
  private EmailService emailservice;
  @Autowired
private MessageService messageservice;
  
  public NotificationService(EmailService emailservice) {
	super();
	this.emailservice = emailservice;
  }
  public void notifyMessage() {
	  emailservice.SendMessage();
  }
  public NotificationService(MessageService messageservice) {
	super();
	this.messageservice = messageservice;
  }
	  public void notifyUser() {
	  }
  }

