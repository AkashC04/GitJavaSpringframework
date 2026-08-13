package com.shaninfotech.BeanScope;

import java.util.UUID;

public class UserTask {
   private String taskName;
   private final String taskId;
   public UserTask(String taskName, String taskId) {
	super();
	this.taskName = taskName;
	this.taskId = UUID.randomUUID().toString().substring(0,8);
   }
   public UserTask() {
	this.taskId = "";
}
   public String getTaskName() {
	return taskName;
   }
   public void setTaskName(String taskName) {
	this.taskName = taskName;
   }
   public String getTaskId() {
	return taskId;
   }
   @Override
   public String toString() {
	return "UserTask [taskName=" + taskName + ", taskId=" + taskId + "]";
   }
   
   
   
}
