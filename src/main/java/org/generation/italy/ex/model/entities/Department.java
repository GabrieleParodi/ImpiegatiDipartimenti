package org.generation.italy.ex.model.entities;

import java.util.Set;

public class Department {
    private long id;
    private String name;
    private String address;
    private int maxCapacity;
    private Set<Employee> setEmployee;

    public Department(){
    }
    public Department(long id, String name, String address, int maxCapacity) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.maxCapacity = maxCapacity;
    }
    public Department(long id, String name, String address, int maxCapacity, Set<Employee> setEmployee) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.maxCapacity = maxCapacity;
        this.setEmployee = setEmployee;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public Set<Employee> getSetEmployee() {
        return setEmployee;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void addEmployee(Employee e){
        setEmployee.add(e);
    }
}
