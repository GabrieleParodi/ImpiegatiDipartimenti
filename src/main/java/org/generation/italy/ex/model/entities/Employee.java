package org.generation.italy.ex.model.entities;

import java.time.LocalDate;

public class Impiegato {
    private long id;
    private String firstname;
    private String lastname;
    private LocalDate hireDate;
    private char Sex;

    public Impiegato(){

    }
    public Impiegato(long id, String firstname, String lastname, LocalDate hireDate, char sex) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.hireDate = hireDate;
        Sex = sex;
    }

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public char getSex() {
        return Sex;
    }
}
