package com.shaninfo.springframework.josDB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "employee")
public class EmployeeEntity {
      @Id 
      @Column(name="emp_id")
      private int empId;
      
      @Column (name ="emp_name")
      private String empName;
      
      @Column (name ="department")
      private String department;
      
      @Column (name ="salary")
      private double salary;
      
      public EmployeeEntity() {
    	  
      }

	  public EmployeeEntity(int empId, String empName, String department, double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.department = department;
		this.salary = salary;
	  }

	  public int getEmpId() {
		  return empId;
	  }

	  public void setEmpId(int empId) {
		  this.empId = empId;
	  }

	  public String getEmpName() {
		  return empName;
	  }

	  public void setEmpName(String empName) {
		  this.empName = empName;
	  }

	  public String getDepartment() {
		  return department;
	  }

	  public void setDepartment(String department) {
		  this.department = department;
	  }

	  public double getSalary() {
		  return salary;
	  }

	  public void setSalary(double salary) {
		  this.salary = salary;
	  }

	  @Override
	  public String toString() {
		return "EmployeeEntity [empId=" + empId + ", empName=" + empName + ", department=" + department + ", salary="
				+ salary + "]";
	  }


      
}
