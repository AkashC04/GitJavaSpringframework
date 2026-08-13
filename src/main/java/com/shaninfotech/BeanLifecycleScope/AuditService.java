package com.shaninfotech.BeanLifecycleScope;

public class AuditService {
	 public void record(String message) {
		 System.out.println("    [AUDIT]"+message);
	 }
}
