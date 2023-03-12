package org.generation.italy.ex.model.entities;

import java.time.LocalDate;

public class Employee {
    private long id;
    private String firstname;
    private String lastname;
    private LocalDate hireDate;
    private String sex;
    private Department department;
    public Employee(){

    }
    public Employee(long id, String firstname, String lastname, LocalDate hireDate, String sex) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.hireDate = hireDate;
        this.sex = sex;
    }
    public Employee(long id, String firstname, String lastname, LocalDate hireDate, String sex, Department department) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.hireDate = hireDate;
        this.sex = sex;
        this.department = department;
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

    public String getSex() {
        return sex;
    }

    public Department getDepartment() {
        return department;
    }

    public void setId(long id) {
        this.id = id;
    }
}
