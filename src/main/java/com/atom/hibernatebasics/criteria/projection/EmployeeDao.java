package com.atom.hibernatebasics.criteria.projection;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.Collection;
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

    public void oneFieldTest(Session session) {
        System.out.println("\n--oneFieldTest--");
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Employee> from = criteriaQuery.from(Employee.class);
        criteriaQuery.select(from.get("id"));
        List<Long> resultList = session.createQuery(criteriaQuery).list();
        System.out.print("{");
        for(Object id: resultList){
            System.out.print(id+",");
        }
        System.out.print("}");
    }
}
