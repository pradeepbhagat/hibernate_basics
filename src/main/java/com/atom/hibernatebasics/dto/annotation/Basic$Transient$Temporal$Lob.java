package com.atom.hibernatebasics.dto.annotation;

import jakarta.persistence.*;

import java.util.Date;
//Revision date - 16/03/2023
@Entity(name = "Annotation")
public class Basic$Transient$Temporal$Lob {
    /**
     * Basic is used to map the java data type to the SQL data type like int/long will be converted to Integer in SQL. String will be converted to varchar in SQL
     * it has two option OPTIONAL and FETCH.
     * OPTIONAL is a boolean which is used to restrict null type. If set to false NULL will not be allowed, by default it is true.
     * FETCH is used to get the value EAGER or LAZY. By default, it is eager.
     */
    @Id
    @Basic
    private int id;

    /**
     * Transient will ignore the property to map with a column. A column will not be created.
     * --Another way of doing it is setting the variable to Static--
     */
    @Transient
    private String notADatabaseColumn;

    /**
     * If the temporal annotation is not used then date and time will be saved in the database. If we want to save only date or only time
     * or timestamp then temporal can be used to filter the input.
     */
    @Temporal(TemporalType.DATE)
    private Date date;

    /**
     * By default, string is mapped with varchar of size 255 if we want to save a large data then LOB is used. LOB is of two types BLOB(Bytes) and CLOB (Character)
     * Hibernate handles automatically the type of LOB to use as per the datatype. For Character, it uses CLOB and for bytes BLOB.
     */
    @Lob
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNotADatabaseColumn() {
        return notADatabaseColumn;
    }

    public void setNotADatabaseColumn(String notADatabaseColumn) {
        this.notADatabaseColumn = notADatabaseColumn;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
