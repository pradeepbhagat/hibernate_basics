package com.atom.hibernatebasics.relationship.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneTest {
    public static void main(String[] args){
        Locker locker = new Locker();
        locker.setName("Test Locker name 1");

        Employee employee = new Employee();
        employee.setName("Test Employee name 1");
        employee.setLocker(locker);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(employee);
        session.getTransaction().commit();
//        session.close();
    }
}
