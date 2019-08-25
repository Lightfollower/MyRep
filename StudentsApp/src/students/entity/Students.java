package students.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Students {
    private String firstName;
    private String surName;
    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }
}
