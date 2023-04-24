package com.atom.hibernatebasics.cache.secondlevel.querycache;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDao {
    public Employee getEmployeeById(int i, Session session) {
        Query query = session.createQuery("from Employee where id = " + i);
        /**
         * To enable to query cache for read and write
         */
        query.setCacheable(true);
        List list = query.list();
        return (Employee) list.get(0);
    }
}
