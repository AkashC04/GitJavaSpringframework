package com.shaninfo.springframework.josDB;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Add employee
    @Transactional
    public void addEmployee(EmployeeEntity employee) {

        if (!employeeRepository.existsById(employee.getEmpId())) {
            employeeRepository.save(employee);
        }
    }

    // Get one employee
    @Transactional(readOnly = true)
    public EmployeeEntity getEmployee(int empId) {

        return employeeRepository.findById(empId);
    }

    // Get all employees
    @Transactional(readOnly = true)
    public List<EmployeeEntity> getAllEmployees() {

        return employeeRepository.findAll();
    }

    // Get employees by department
    @Transactional(readOnly = true)
    public List<EmployeeEntity> getEmployeesOfDepartment(String department) {

        return employeeRepository.findByDepartment(department);
    }

    // Give salary increment
    @Transactional
    public void giveIncrement(int empId, double percentage) {

        EmployeeEntity employee =
                employeeRepository.findById(empId);

        if (employee != null) {

            double hike =
                    employee.getSalary() * percentage / 100;

            employee.setSalary(employee.getSalary() + hike);

            employeeRepository.update(employee);
        }
    }

    // Remove employee
    @Transactional
    public void removeEmployee(int empId) {

        employeeRepository.deleteById(empId);
    }

    // Count employees in department
    @Transactional(readOnly = true)
    public long countInDepartment(String department) {

        return employeeRepository.countByDepartment(department);
    }

    // Total employees
    @Transactional(readOnly = true)
    public long totalEmployees() {

        return employeeRepository.count();
    }
}