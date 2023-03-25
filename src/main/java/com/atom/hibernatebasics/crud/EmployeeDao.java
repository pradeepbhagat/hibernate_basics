package com.atom.hibernatebasics.crud;

import org.hibernate.Session;

public class EmployeeDao {
    public void create(Session session){
        for(int i=0; i<10; i++){
            Employee employee = new Employee();
            employee.setName("Employee name "+i);
            session.persist(employee);
        }
    }

    public Employee getEmployee(int empId, Session session){
        return session.get(Employee.class, empId);
    }

    public void updateEmployeeName(int empId, String newName, Session session) {
        Employee employee = session.get(Employee.class, empId);
        employee.setName(newName);
        session.persist(employee);
    }

    public void deleteEmployee(int id, Session session) {
        Employee employee = session.get(Employee.class, id);
        session.remove(employee);
    }
}
