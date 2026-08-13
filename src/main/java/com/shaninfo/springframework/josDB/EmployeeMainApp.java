package com.shaninfo.springframework.josDB;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeMainApp {
 public static void main(String [] args) {
	 AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
	 EmployeeService employeeService = context.getBean(EmployeeService.class);
	 
	 
	 // cteate
	 System.out.println("==============addinf amployee=================");
	 employeeService.addEmployee(new EmployeeEntity(101,"akash","designer", 650000.0));
	 employeeService.addEmployee(new EmployeeEntity(102,"vary","develop", 450000.0));
	 employeeService.addEmployee(new EmployeeEntity(103,"dev","tester", 540000.0));

	 
	 System.out.println("===============all employeee================");
	 List<EmployeeEntity> allEmployees = employeeService.getAllEmployees();
	 for (EmployeeEntity employee : allEmployees) {
		 System.out.println(""+employee);
	 }
	 System.out.println("===============all employeee================");
	 List<EmployeeEntity> devTeams = employeeService.getAllEmployees();
	 for (EmployeeEntity employee : devTeams) {
		 System.out.println(""+employee);
	 }
	 
	 System.out.println("==========fetch employee============");
	 
	 System.out.println(""+employeeService.getEmployee(102));
	 
	 
	 System.out.println("=============increamnet=========");
	 employeeService.giveIncrement(102, 10);
	 System.out.println(""+employeeService.getEmployee(102));
	 
	 System.out.println("=======delete=============");
	 employeeService.removeEmployee(103);
	 
	 System.out.println("===============count=========");
	 System.out.println("total employee:"+ employeeService.totalEmployees());
	 System.out.println("total employee:"+ employeeService.countInDepartment("develop"));
	 context.close();

 }
 


}

