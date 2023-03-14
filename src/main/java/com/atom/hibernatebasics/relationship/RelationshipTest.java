package com.atom.hibernatebasics.relationship;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RelationshipTest {
    public static void main(String[] args){
        Locker locker = new Locker();
        locker.setName("Test Locker name 1");

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setName("Car 1");

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setName("Car 2");

        Employee employee = new Employee();
        employee.setName("Test Employee name 1");
        employee.setLocker(locker);
        employee.addVehicle(vehicle1);
        employee.addVehicle(vehicle2);

        Department department = new Department();
        department.setName("Department 1");
        department.addEmployee(employee);

        Project project = new Project();
        project.setName("Project 1");
        project.addEmployee(employee);

        employee.addProject(project);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(employee);
        /**
         * Locker is not persisted because cascade attribute is used and set to ALL in the Employee class
         */
//        session.persist(locker);

        /**
         * Vehicle is persisted because casacde is not used in the @OneToMany in the Employee class
         */
        session.persist(vehicle1);
        session.persist(vehicle2);
        session.persist(department);
        session.persist(project);

        session.getTransaction().commit();
        session.close();
    }
}
