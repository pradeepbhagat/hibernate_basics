package com.atom.hibernatebasics.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InheritanceTest {
    public static void main(String[] args){
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Vehicle");

        TwoWheeler bike = new TwoWheeler();
        bike.setName("Yamaha 250");
        bike.setBackTyrePressure(38);
        bike.setBackTyrePressure(30);

        FourWheeler car = new FourWheeler();
        car.setName("Maruti Baleno");
        car.setTyrePressure(33);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(vehicle);
        session.persist(bike);
        session.persist(car);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }
}
