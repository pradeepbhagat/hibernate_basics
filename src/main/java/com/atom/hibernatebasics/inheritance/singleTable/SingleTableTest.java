package com.atom.hibernatebasics.inheritance.singleTable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SingleTableTest {
    public static void main(String[] args){
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Vehicle");

        TwoWheeler yamaha = new TwoWheeler();
        yamaha.setFrontTyrePressure(30);
        yamaha.setBackTyrePressure(33);
        yamaha.setName("Fz250");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(vehicle);
        session.persist(yamaha);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
