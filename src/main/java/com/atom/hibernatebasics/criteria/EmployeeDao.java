package com.atom.hibernatebasics.criteria;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;

import java.util.Iterator;
import java.util.List;

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
    public void displayAllEmployees(Session session) {
        System.out.println("\n--displayAllEmployees--");
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery  = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> from = criteriaQuery.from(Employee.class);
        criteriaQuery.select(from);
        Query<Employee> query = session.createQuery(criteriaQuery);
        List<Employee> list = query.list();
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

    public void whereExample(Session session) {
        System.out.println("\n--whereExample--");
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> from = criteriaQuery.from(Employee.class);
        criteriaQuery.select(from).where(criteriaBuilder.equal(from.get("name"), "Employee 2"));
        Query<Employee> query = session.createQuery(criteriaQuery);
        List<Employee> list = query.list();
        printEmployeeList(list);
    }
    public void greaterThanExample(Session session) {
        System.out.println("\n--greaterThanExample--");
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> from = criteriaQuery.from(Employee.class);
        criteriaQuery.select(from).where(criteriaBuilder.greaterThan(from.get("id"),5));
        Query<Employee> query = session.createQuery(criteriaQuery);
        List<Employee> list = query.list();
        printEmployeeList(list);
    }


    public void likeExample(Session session) {
        System.out.println("\n--likeExample--");
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> from = criteriaQuery.from(Employee.class);
        criteriaQuery.select(from).where(criteriaBuilder.like(from.get("name"), "Employee 1%"));
        Query<Employee> query = session.createQuery(criteriaQuery);
        List<Employee> list = query.list();
        printEmployeeList(list);
    }
    public void betweenExample(Session session) {
        System.out.println("\n--betweenExample--");
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> from = criteriaQuery.from(Employee.class);
        criteriaQuery.select(from).where(criteriaBuilder.between(from.get("id"),2,7));

        Query<Employee> query = session.createQuery(criteriaQuery);
        List<Employee> list = query.list();
        printEmployeeList(list);
    }

    public void orExample(Session session) {
        System.out.println("\n--orExample--");
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> from = criteriaQuery.from(Employee.class);
        criteriaQuery.select(from).where(criteriaBuilder.or(criteriaBuilder.between(from.get("id"),1,3),
                criteriaBuilder.between(from.get("id"),7,9)));
        Query<Employee> query = session.createQuery(criteriaQuery);
        List<Employee> list = query.list();
        printEmployeeList(list);
    }
}
