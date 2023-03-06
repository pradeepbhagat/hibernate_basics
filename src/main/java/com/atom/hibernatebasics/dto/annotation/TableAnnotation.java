package com.atom.hibernatebasics.dto.annotation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Difference between entity and table is-
 * First understand the default behaviour
 * if we only write @Entity then a table will be created with the classname and the entity name is the class name.
 *
 * if we use @Entity(name="") then a table will be created with the value of name and the entity name is also the value from the name.
 *
 *  If we use @Entity and @Table(name="") then a table will be created with the value of name in Table annotation
 *  Entity name will be the class name.
 *
 * If we use @Entity(name="") and @Table(name="") then a table will be created with the value of name in Table annotation
 *  and entity name will be value of the name attribute of Entity annotation.
 *
 */
@Entity
@Table(name="userdetails")
public class TableAnnotation {
    @Id
    private int userId;
    private String userName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
