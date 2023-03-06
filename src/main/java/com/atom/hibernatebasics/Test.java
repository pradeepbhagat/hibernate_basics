package com.atom.hibernatebasics;

import com.atom.hibernatebasics.dto.ByNameAttribute;
import com.atom.hibernatebasics.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    /**
     * 1. Create a session factory - this is one object per application and gets automatically created by
     * hibernate.cfg.xml
     *
     * 2. Create a session from the session factory.
     *
     * 3. Use the session to save model objects.
     */
    public static void main(String[] args){
        UserDetails userDetails = new UserDetails();
        userDetails.setUserId(2);
        userDetails.setUserName("Test name2");

        ByNameAttribute byNameAttribute = new ByNameAttribute();
        byNameAttribute.setProp1(1);
        byNameAttribute.setProp2("Test name 1");
        byNameAttribute.setProp3(30);

        //Configuration will read the hibernate.cfg.xml
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(userDetails);
        session.persist(byNameAttribute);
        session.getTransaction().commit();
        session.close();


    }
}
