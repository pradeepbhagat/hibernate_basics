package com.atom.hibernatebasics.lifecycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LifeCycleTest {
    public static void main(String[] args){
//        transientPersistentDetached();
        detachToPersistentState();
    }

    private static void transientPersistentDetached() {
        /**
         * TRANSIENT STATE
         */
        Employee employee = new Employee();
        employee.setName("Employee 1");

        Employee deletedEmployee = new Employee();
        employee.setName("Delete Employee");
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        /**
         * PERSISTENT STATE
         */
        session.persist(employee);
        session.persist(deletedEmployee);
        /**
         * No need of calling session.persist() again
         * simply setName will update the database because employee object is in persistent state
         */
        employee.setName("Employee new name in persistent state");

        /**
         * PERSISTENT STATE to TRANSIENT STATE
         * when session.remove()
         */
        session.remove(deletedEmployee);
        /**
         * setName will not update the database because deletedEmployee is in transient state
         */
        deletedEmployee.setName("Deleted employee new name in persistent state");

        session.getTransaction().commit();
        session.close();

        /**
         * DETACHED STATE
         * setName will not update the database as it is in detached state as session.close is called
         */
        employee.setName("Employee new name in persistent state");
    }

    public static void detachToPersistentState(){
        Employee employee = new Employee();
        employee.setName("Transient state");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(employee);
        Employee employee1 = session.get(Employee.class, 1);
        session.getTransaction().commit();
        session.close();

        employee1.setName("Detached State");

        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(employee1);
        employee1.setName("Name after detach to persistent");
        session.getTransaction().commit();
        session.close();
    }
}
