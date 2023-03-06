package com.atom.hibernatebasics.embed;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class EmbedTest {
    public static void main (String[] args){
        Address testEmp1HomeAddress = new Address();
        testEmp1HomeAddress.setCity("Home City 1");
        testEmp1HomeAddress.setPincode("000000");
        testEmp1HomeAddress.setState("Home State 1");
        testEmp1HomeAddress.setStreet("Home Street 1");

        Address testEmp1OfficeAddress = new Address();
        testEmp1OfficeAddress.setCity("Office City 1");
        testEmp1OfficeAddress.setPincode("Office 000000");
        testEmp1OfficeAddress.setState("Office State 1");
        testEmp1OfficeAddress.setStreet("Office Street 1");

        CustomPrimaryKey customPrimaryKey = new CustomPrimaryKey();
        customPrimaryKey.setFirstId(1);
        customPrimaryKey.setSecondId(1);

        Employee testEmp1 = new Employee();
        testEmp1.setId(customPrimaryKey);
        testEmp1.setHomeAddress(testEmp1HomeAddress);
        testEmp1.setOfficeAddress(testEmp1OfficeAddress);
        testEmp1.setName("Test Employee 1");
        testEmp1.setDateOfBirth(new Date("13/02/1988"));
        testEmp1.setPhoneNumber("9004460339");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(testEmp1);
        session.getTransaction().commit();
        session.close();

        sessionFactory.close();
    }
}
