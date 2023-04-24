package com.atom.hibernatebasics.cache.secondlevel;

import org.hibernate.Session;

public class EmployeeDao {
    public void fillEmployeeDetails(Session session) {
        System.out.println("\n--fillEmployeeDetails--");
//        session.beginTransaction();
        for (int i=1; i< 15; i++){
            Employee employee = new Employee();
            employee.setName("Employee name "+i);
            employee.setDepartment("Department "+i%2);
            session.persist(employee);
        }
//        session.getTransaction().commit();
    }

    public Employee getEmployee(int id, Session session) {
        System.out.println("\n--Get employee by id--");
//        session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
//        session.getTransaction().commit();
        return employee;
    }
}
