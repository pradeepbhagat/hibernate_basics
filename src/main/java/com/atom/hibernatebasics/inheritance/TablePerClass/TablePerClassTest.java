package com.atom.hibernatebasics.inheritance.TablePerClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TablePerClassTest {
    public static void main(String[] args){
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Car");

        TwoWheeler twoWheeler = new TwoWheeler();
        twoWheeler.setName("Yamaha Fz250");
        twoWheeler.setFrontTyrePressure(30);
        twoWheeler.setBackTyrePressure(33);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(vehicle);
        session.persist(twoWheeler);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
