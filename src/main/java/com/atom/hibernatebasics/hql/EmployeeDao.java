package com.atom.hibernatebasics.hql;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class EmployeeDao {
    public void fillEmployeeData(Session session) {
        System.out.println("--Insert employee--");
        for(int i=1; i<= 10 ; i++){
            Employee employee = new Employee();
            employee.setName("Employee "+i);
            session.persist(employee);
        }
    }

    public void selectQuery(Session session) {
        System.out.println("--Select Query--");
        Query fromEmployee = session.createQuery("from Employee");
        List list = fromEmployee.list();
        printEmployeeList(list);
    }

    private static void printEmployeeList(List list) {
        Iterator iterator = list.iterator();
        int i=0;
        while (iterator.hasNext()){
            Employee employee = (Employee) iterator.next();
            System.out.print(employee.getName()+",");
            i++;
        }
        System.out.println("");
        System.out.println("Size: "+ i);
    }

    public void whereQuery(Session session) {
        System.out.println("--Where query--");
        Query query = session.createQuery("from Employee where id > 5");
        List list = query.list();
        printEmployeeList(list);
    }
}
