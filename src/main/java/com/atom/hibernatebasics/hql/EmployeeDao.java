package com.atom.hibernatebasics.hql;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.*;

public class EmployeeDao {
    public void fillEmployeeData(Session session) {
        System.out.println("--Insert employee--");
        for(int i=1; i<= 10 ; i++){
            Employee employee = new Employee();
            employee.setName("Employee "+i);
            employee.setDepartment("Department "+ i % 2);
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
        while (iterator.hasNext()){
            Employee employee = (Employee) iterator.next();
            System.out.print("["+employee.getName()+",");
            System.out.print(employee.getDepartment()+"]");
        }
        System.out.println("");
        System.out.println("Size: "+list.size());
    }

    public void whereQuery(Session session) {
        System.out.println("--Where query--");
        Query query = session.createQuery("from Employee where id > 5");
        List list = query.list();
        printEmployeeList(list);
    }

    public void pagination(Session session) {
        System.out.println("--Pagination-");
        Query query = session.createQuery("from Employee ");
        query.setFirstResult(2);// start from the nth record
        query.setMaxResults(5); //Total number of record to be fetched
        List<Employee> list = query.list();
        printEmployeeList(list);
    }

    public void oneColumn(Session session) {
        System.out.println("--oneColumn-");
        Query query = session.createQuery("select name from Employee ");
        List<String> list = query.list(); // It will give a list of strings
        for (String name: list){
            System.out.print(name+",");
        }
        System.out.println("");
        System.out.println("Size: "+ list.size());
    }

    public void twoColumn(Session session) {
        Query query = session.createQuery("select name, department from Employee ");
        List<Object[]> employees = query.list();
        for (Object[] instance: employees){
            System.out.print("["+instance[0]+","+instance[1]+"]");
        }
    }

    public void maxId(Session session) {
        System.out.println("-- maxId--");
        Query query = session.createQuery("select max(id) from Employee");
        List list = query.list();
        System.out.println("Max id: "+list.get(0));
    }

    public void mapOfColumn(Session session) {
        System.out.println("--mapOfColumn--");
        Query query = session.createQuery("select new map(id, name) from Employee");
        List<Map> list = query.list();
        for (Map map : list){
            System.out.print(""+map);
        }
    }

    public void parameterBindingWithIndex(Session session) {
        System.out.println("\n--parameterBinding--");
        Query query = session.createQuery("from Employee where id > ?1 ");
        query.setParameter(1,3);// 1 index of the parameter and 3 is the value of ?
        List list = query.list();
        printEmployeeList(list);
    }

    public void parameterBindingWithName(Session session) {
        System.out.println("\n--parameterBindingWithName--");
        Query query = session.createQuery("from Employee where id > :userId ");
        query.setParameter("userId", 5);
        List list = query.list();
        printEmployeeList(list);
    }

    public void namedQuery(Session session){
        System.out.println("\n--namedQuery--");
        Query namedQuery = session.getNamedQuery("Employee.byId");
        namedQuery.setParameter(1,3);
        List list = namedQuery.list();
        printEmployeeList(list);
    }

    public void namedNativeQuery(Session session) {
        System.out.println("\n--namedNativeQuery--");
        Query query = session.getNamedQuery("Employee.byName");
        query.setParameter(1, "Employee 5");
        List list = query.list();
        printEmployeeList(list);
    }
}
