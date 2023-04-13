package com.atom.hibernatebasics.cache;

import org.hibernate.Session;

public class EmployeeDao {
    public void fillEmployeeData(Session session) {
        System.out.println("--Insert employee--");
        for(int i=1; i<= 10 ; i++){
            Employee employee = new Employee();
            employee.setName("Employee "+i);
            employee.setDepartment("Department "+ i % 2);
            session.persist(employee);
        }
    }
    public void getTwoEmployeeObjectFromSessionGet(Session session) {
        System.out.println("\n--getTwoEmployeeObjectFromSessionGet--");
        /**
         * A select query will be triggered
         */
        Employee employee1 = session.get(Employee.class, 1);
        System.out.println("employee1 object  "+ employee1.toString());

        /**
         * A update query will be triggered
         */
        employee1.setName("new name of employee 1");
        System.out.println("employee1 object  "+ employee1.toString());

        /**
         * No query will be fired the data will be retrived from cache
         */
        Employee employee2 = session.get(Employee.class, 1);
        System.out.println("employee2 object "+ employee1.toString());
    }

    public void getTwoEmployeeObjectFromDifferentSessionGet(Session session1) {
        System.out.println("\n--getTwoEmployeeObjectFromDifferentSessionGet--");
        /**
         * A select query will be triggered
         */
        Employee employee1 = session1.get(Employee.class, 1);
        System.out.println("employee1 object  "+ employee1.toString());
    }
}
