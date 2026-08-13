package com.shaninfotech.BeanScope;

import java.util.UUID;

public class GlobalConfig {
     private String appName;
     private final String instanceId;
	 public GlobalConfig(String appName, String instanceId) {
		super();
		this.appName = appName;
		this.instanceId = UUID.randomUUID().toString().substring(0,8);
	 }
	 public GlobalConfig() {
		this.instanceId = "";
	}
	 public String getAppName() {
		 return appName;
	 }
	 public void setAppName(String appName) {
		 this.appName = appName;
	 }
	 public String getInstanceId() {
		 return instanceId;
	 }
	 @Override
	 public String toString() {
		return "GlobalConfig [appName=" + appName + ", instanceId=" + instanceId + "]";
	 }
     
     
}
