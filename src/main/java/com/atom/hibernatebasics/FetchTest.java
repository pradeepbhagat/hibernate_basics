package com.atom.hibernatebasics;

import com.atom.hibernatebasics.dto.fetch.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class FetchTest {
    public static void main(String[] args){
        User user = new User();
//        user.setId(1);
        user.setName("Test name");
        user.setDescription("This is test description");
        user.setAddress("Test address");
        user.setDate(new Date());

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        User fetchedUser = session.get(User.class, 1);
        System.out.println(fetchedUser.toString());
        session.close();
        sessionFactory.close();
    }
}
