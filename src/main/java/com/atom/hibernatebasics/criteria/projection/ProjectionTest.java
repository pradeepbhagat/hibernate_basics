package com.atom.hibernatebasics.criteria.projection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Projection is used to extract the subset of the entity.
 * It is also used for extracting the grouping function such as count or max or min
 */
public class ProjectionTest {
    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        EmployeeDao employeeDao = new EmployeeDao();

        employeeDao.fillEmployeeData(session);

        employeeDao.oneFieldTest(session);


        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
