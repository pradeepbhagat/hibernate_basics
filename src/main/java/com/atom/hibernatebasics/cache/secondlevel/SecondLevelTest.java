package com.atom.hibernatebasics.cache.secondlevel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevelTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        EmployeeDao employeeDao = new EmployeeDao();
//        employeeDao.fillEmployeeDetails(session);

        /**
         * The below statement will trigger select statement
         */
        Employee employee = employeeDao.getEmployee(1, session);
        System.out.print(employee.toString());

        /**
         * This statement will not trigger select statement
         */
        Employee employee1 = employeeDao.getEmployee(1, session);
        System.out.print(employee1.toString());

        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();

        /**
         * The below statement will trigger select statement
         */
        Employee employee2 = employeeDao.getEmployee(1, session);
        System.out.print(employee2.toString());

        sessionFactory.close();
    }
}
