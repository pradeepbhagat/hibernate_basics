package com.atom.hibernatebasics.cache.secondlevel.querycache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryCacheTest {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        EmployeeDao employeeDao = new EmployeeDao();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Employee employee = employeeDao.getEmployeeById(1, session);
        System.out.println(employee.toString());
        session.getTransaction().commit();
        session.close();

        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        Employee employee2 = employeeDao.getEmployeeById(1, session2);
        System.out.println(employee2.toString());
        session2.getTransaction().commit();
        session2.close();


        sessionFactory.close();
    }
}
