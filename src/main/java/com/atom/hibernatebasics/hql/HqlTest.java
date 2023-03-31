package com.atom.hibernatebasics.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HqlTest {
    public static void main(String[] args){
        EmployeeDao employeeDao = new EmployeeDao();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        employeeDao.fillEmployeeData(session);

        employeeDao.selectQuery(session);

        employeeDao.whereQuery(session);

        session.getTransaction().commit();
        session.close();
    }
}