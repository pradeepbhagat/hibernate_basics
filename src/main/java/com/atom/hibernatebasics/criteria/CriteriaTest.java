package com.atom.hibernatebasics.criteria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CriteriaTest {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        EmployeeDao employeeDao = new EmployeeDao();

        employeeDao.fillEmployeeData(session);
        employeeDao.displayAllEmployees(session);
        employeeDao.whereExample(session);
        employeeDao.greaterThanExample(session);
        employeeDao.likeExample(session);
        employeeDao.betweenExample(session);
        employeeDao.orExample(session);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
