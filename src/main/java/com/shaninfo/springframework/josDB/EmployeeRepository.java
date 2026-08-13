package com.shaninfo.springframework.josDB;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

    private final SessionFactory sessionFactory;

    public EmployeeRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Helper method
    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    // Save employee
    public void save(EmployeeEntity employee) {
        session().save(employee);
    }

    // Find by ID
    public EmployeeEntity findById(int empId) {
        return session().get(EmployeeEntity.class, empId);
    }

    // Find all employees
    public List<EmployeeEntity> findAll() {

        return session()
                .createQuery(
                        "FROM EmployeeEntity ORDER BY empId",
                        EmployeeEntity.class
                )
                .getResultList();
    }

    // Find by department
    public List<EmployeeEntity> findByDepartment(String department) {

        return session()
                .createQuery(
                        "FROM EmployeeEntity WHERE department = :dept ORDER BY empId",
                        EmployeeEntity.class
                )
                .setParameter("dept", department)
                .getResultList();
    }

    // Update employee
    public void update(EmployeeEntity employee) {
        session().update(employee);
    }

    // Delete by ID
    public void deleteById(int empId) {

        EmployeeEntity employee =
                session().get(EmployeeEntity.class, empId);

        if (employee != null) {
            session().delete(employee);
        }
    }

    // Count by department
    public long countByDepartment(String department) {

        return session()
                .createQuery(
                        "SELECT COUNT(e) FROM EmployeeEntity e WHERE e.department = :dept",
                        Long.class
                )
                .setParameter("dept", department)
                .getSingleResult();
    }

    // Count all employees
    public long count() {

        return session()
                .createQuery(
                        "SELECT COUNT(e) FROM EmployeeEntity e",
                        Long.class
                )
                .getSingleResult();
    }

    // Check existence
    public boolean existsById(int empId) {

        return session().get(EmployeeEntity.class, empId) != null;
    }
}