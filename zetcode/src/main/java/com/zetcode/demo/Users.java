package com.zetcode.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String pass;

    protected Users() {}

    public Users(String name, String pass) {
        this.name = name;
        this.pass = pass;

    }

    @Override
    public String toString() {
        return String.format(
                "Users[id=%d, name='%s', pass='%s']",
                id, name, pass);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }
}