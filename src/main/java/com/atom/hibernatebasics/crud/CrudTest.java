package com.atom.hibernatebasics.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CrudTest {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        EmployeeDao employeeDao = new EmployeeDao();
        //Create
        employeeDao.create(session);
        //Read
        System.out.println("Employee details: "+employeeDao.getEmployee(4, session).toString());
        //Update
        employeeDao.updateEmployeeName(4, "New name", session);
        System.out.println("Employee details after update: "+employeeDao.getEmployee(4, session).toString());

        //Delete
        employeeDao.deleteEmployee(4, session);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
