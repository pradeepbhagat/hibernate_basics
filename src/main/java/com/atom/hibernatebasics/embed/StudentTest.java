package com.atom.hibernatebasics.embed;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class StudentTest {
    public static void main(String[] args){
        Address address1 = new Address();
        address1.setCity("Home City 1");
        address1.setPincode("000000");
        address1.setState("Home State 1");
        address1.setStreet("Home Street 1");

        Address address2 = new Address();
        address2.setCity("Office City 1");
        address2.setPincode("Office 000000");
        address2.setState("Office State 1");
        address2.setStreet("Office Street 1");

        Student student = new Student();

        student.getOtherAddresses().add(address1);
        student.getOtherAddresses().add(address2);

        student.getEagerFetchAddresses().add(address1);
        student.getEagerFetchAddresses().add(address2);

        student.setName("Student 1");
        student.setDateOfBirth(new Date("13/02/1988"));
        student.setPhoneNumber("9004460339");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(student);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        Student student1 = session.get(Student.class, 1);
        System.out.println(student1.getOtherAddresses().size());
        session.close();
//        System.out.println(student1.getOtherAddresses().size()); // This will throw exception as the lazy loading will not work because session is close
        System.out.println(student1.getEagerFetchAddresses().size()); // This will work as the fetch type is eager

        sessionFactory.close();
    }
}
