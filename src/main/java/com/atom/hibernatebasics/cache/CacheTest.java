package com.atom.hibernatebasics.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CacheTest {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        EmployeeDao employeeDao = new EmployeeDao();

        employeeDao.fillEmployeeData(session);
        employeeDao.getTwoEmployeeObjectFromSessionGet(session);

        session.getTransaction().commit();

        session.close();

        Session session1 = sessionFactory.openSession();
        employeeDao.getTwoEmployeeObjectFromDifferentSessionGet(session1);
        session1.close();

        sessionFactory.close();
    }
}
